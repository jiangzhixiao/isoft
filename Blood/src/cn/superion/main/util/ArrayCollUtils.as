package cn.superion.main.util
{
	import mx.collections.ArrayCollection;
	import mx.collections.ArrayList;

	/**
	 * 数组集合操作工具类
	 * */
	public class ArrayCollUtils
	{
		public static function addObjToArray(ary:Array, v:*, keyField:*):*
		{
			if (!ary)
				ary=[]
			for each (var it:* in ary)
			{
				if (it[keyField] == v[keyField])
				{
					for (var field:* in it)
					{
						it[field]=v[field]
					}
					return
				}
			}
			ary.push(v);
		}

		public static function addToArray(ary:Array, v:*):*
		{
			if (!ary)
				ary=[]
			for each (var it:* in ary)
			{
				if (it == v)
				{
					return
				}
			}
			ary.push(v);
		}

		public static function pushArrayToArray(targetArray:Array, array:Array):*
		{
			for each (var it:* in array)
			{
				targetArray.push(it)
			}
		}
		public static function removeItemFromArrayCollection(fary:ArrayCollection, v:Object):void
		{
			for each(var item:Object in fary){
				if(item==v){
					fary.removeItemAt(fary.getItemIndex(item));
				}
			}
		}

		public static function removeFromArray(ary:Array, v:Object):*
		{
			if (!ary)
				ary=[]
			var reAry:*=[]
			for each (var it:* in ary)
			{
				if (it != v)
				{
					reAry.push(it)
				}
			}
			return reAry;
		}

		public static function removeItemByFieldValue(farray:*, field:*, value:*):*
		{
			if (farray is Array)
			{
				farray=new ArrayCollection(farray);
			}
			for each (var item:* in farray)
			{
				if (item[field] == value)
				{
					farray.removeItemAt(farray.getItemIndex(item))
					return;
				}
			}
		}

		/**
		 * 转换一个平数组为结构对象数组
		 * 子字段为children
		 * 用到了findItInAryByKey方法
		 * 参数 array  平数组
		 *     groupField 要进行分组的字段
		 * 返回值 结构对象数组
		 * */
		public static function arrayToHierarchicalObj(array:*, groupField:*):*
		{

			var hieAry:*=[]
			for each (var it:* in array)
			{
				var searchedItem:*=findItInAryByKey(it, groupField, hieAry)
				if (searchedItem == null)
				{
					var obj:*={}
					obj[groupField]=it[groupField]
					var children:*=[]
					it[groupField]=undefined
					children.push(it)
					obj.children=children
					it.parent=obj
					hieAry.push(obj)
				}
				else
				{
					it[groupField]=undefined
					it.parent=searchedItem
					searchedItem.children.push(it)
				}
			}
			return hieAry
		}

		//查找当前项是否存在，存在就返回当前数据对象
		public static function findItemInArrayByValue(array:*, field:*, value:*):*
		{
			for each (var it:* in array)
			{
				if (it && it[field] == value)
				{
					return it
				}
			}
			return null
		}

		/**
		 * 查找对象it是否存在于数组hieAry中
		 * 查找条件字段keyField
		 * 参数 it 查找对象
		 *     keyField 条件字段
		 *     hieAry 目标数组
		 * 返回值 找到的对象  未找到--null
		 * */
		public static function findItInAryByKey(it:*, keyField:*, hieAry:*):*
		{
			for each (var item:* in hieAry)
			{
				if (item[keyField] == it[keyField])
					return item
			}
			return null
		}

		/**
		 * 将Array数据构造成树的数据
		 *
		 * config.dataList  原始平数组数据
		 * config.labelField 显示节点label字段
		 * config.rootParentCode 顶级节点上级父节点代码值
		 * config.parentCodeField 父节点字段代码
		 * config.codeField  节点代码字段
		 *
		 * 2010-06-13
		 * */
		public static function buildTreeData(config:*):*
		{
			var newRoot:*
			if (config.dataList is ArrayCollection)
			{
				config.dataList=config.dataList.toArray()
			}
			var roots:*=findRootNode(config)
			if (roots.length == 0)
			{
				return []
			}
			newRoot=roots[0]
			if (roots.length > 1)
			{
				newRoot={children: roots}
				newRoot[config.labelField]="root"
				newRoot[config.parentCodeField]=-100
				newRoot[config.codeField]=config.rootParentCode
			}
			genTreeObjs(config, newRoot)
			return newRoot
		}
        /**
		 * 将树形数据转变成平数组
		 * 参数：root 树形数据
		 *       returnArray 返回的平数组 
		 * */
		public static function changeTreeDataToPlain(root:Object,isRemoveRoot:Boolean=true):Array{
			var returnArray:Array=[]
			if(root is Array || root  is ArrayCollection || root is ArrayList){
				if(root.length>0){
					root=root[0]
				}else{
					return []
				}
			}
			treeDateToPlainArray(root,returnArray)
			if(isRemoveRoot){
				returnArray.shift();
			}
			return returnArray
		}	
		private static function treeDateToPlainArray(root:Object,returnArray:Array):void{

			returnArray.push(root)
			if(!root.children){
				return
			}
			for each(var it:Object in root.children){
				treeDateToPlainArray(it,returnArray)
			}			
		}
		public static function genTreeObjs(config:*, node:*):*
		{
			var curObj:*=node
			var children:*=getChildrenNodesById(config, node);
			for each (var it:* in children)
			{
				it.parent=curObj
				it.children=genTreeObjs(config, it)
			}
			curObj.children=children
			return children
		}
		/**
		 * 将数组转换为分组合计数组并返回
		 * 参数： farray 要修改的数组 可以是Array 或 ArrayCollection
		 *       fgroupFieldName 分组条件字段名
		 *       fsumFields 按照分组合计字段
		 *       fsumLableField 显示“合计”文本的字段
		 *       isCreateGroupTitle 是否显示分组标题
		 * */
		public static function changeToGroupArray(farray:Object,fgroupFieldName:String,fsumFields:Array,fsumLableField:String,isSortGroupName:Boolean=true,isDesc:Boolean=false,isCreateGroupTitle:Boolean=true):Array{
			var lgroupMap:Object={};
			for each(var item:Object in farray){
				if(!lgroupMap[item[fgroupFieldName]]){
					lgroupMap[item[fgroupFieldName]]=[]
					lgroupMap[item[fgroupFieldName]].push(item)
				}else{
					lgroupMap[item[fgroupFieldName]].push(item)
				}
			}
			var keys:Array=[]
			for(var keyItem:Object in lgroupMap){
				keys.push(keyItem);
			}
			if(isSortGroupName){
				if(isDesc){
					keys.sort(Array.DESCENDING)
				}else{
					keys.sort()
				}
			}
			for each(var key:Object in keys){
				if(fgroupFieldName && isCreateGroupTitle){
				    var lgroupTitle:Object=createGroupTitleItem(lgroupMap[key],fsumLableField,key);
				    lgroupMap[key].splice(0,0,lgroupTitle);
				}
				var lsumSumItem:Object= createSumItem(lgroupMap[key],fsumFields,fgroupFieldName,fsumLableField)
				if(lsumSumItem){
					lgroupMap[key].push(lsumSumItem)
				}
			}
			var laryReturn:Array=[]
			for each(var k:Object in keys){
				for each(var fgridItem:Object in lgroupMap[k]){
					laryReturn.push(fgridItem)
				}
			}
			return laryReturn
		}
		private static function createGroupTitleItem(faryGridArray:Object,fsumLableField:String,fstrGroupTitle:Object):Object{
			var titleItem:Object={};
			titleItem[fsumLableField]=fstrGroupTitle;
			titleItem.isTitle=true;
			titleItem.notData=true;
			titleItem.isGroupRow=true;			
			return titleItem;
		}
		private static function createSumItem(faryGridArray:Object,fsumFields:Array,fgroupField:String,fsumLableField:String):Object{
			var sumItem:Object={}
			var groupName:String=""
			var itemsCount:int=0
			for each (var field:Object in fsumFields)
			{
				sumItem[field]=0
			}
			for each (var item:Object in faryGridArray)
			{
				if (item.hasOwnProperty('notData') && item.notData)
				{
					continue
				}
				groupName=item[fgroupField]
				for each (var mfield:Object in fsumFields)
				{
					sumItem[mfield]+=item[mfield]
				}
				itemsCount++
			}	
			sumItem.notData=true
			sumItem.isGroupRow=true
			if(!groupName){
				return null
			}
			sumItem[fsumLableField]="小计 共"+itemsCount+"项";
			return sumItem
		}
		public static function getChildrenNodesById(config:*, node:*):*
		{
			var children:*=[]
			for each (var it:* in config.dataList)
			{
				if (it[config.parentCodeField] == node[config.codeField])
				{
					children.push(it)
				}
			}
			if (children.length == 0)
				children=null
			return children
		}

		public static function findRootNode(config:*):*
		{
			var rootList:*=[]
			for each (var it:* in config.dataList)
			{
				if (it[config.parentCodeField] == config.rootParentCode)
				{
					rootList.push(it)
				}
			}
			return rootList
		}

		public static function addRowIdFieldToArray(array:*, rowIdField:*):*
		{
			var i:*=1;
			for each (var it:* in array)
			{
				it[rowIdField]=String(i);
				i++;
			}
		}

		public static function addRowToArray(array:*, rowField:*, rowValue:*):*
		{
			var i:*=1;
			for each (var it:* in array)
			{
				it[rowField]=rowValue;
				i++;
			}
		}

		public static function filterArray(ary:ArrayCollection, valueField:*, value:*):*
		{
			ary.filterFunction=function(item:*):*
			{
				if (value is String && value == '')
				{
					return true
				}
				return item[valueField] == value
			}
			ary.refresh();
		}

		//判断数据项是否在数组当中
		public static function containSV(array:*, item:*):Boolean
		{
			for each (var it:* in array)
			{
				if (String(it).toUpperCase() == String(item).toUpperCase())
				{
					return true
				}
			}
			return false
		}

		public static function addPleaseChooseItemToArray(array:*, field:*):*
		{
			var arrayCol:ArrayCollection;
			if (array is ArrayCollection)
			{
				arrayCol=array;
			}
			else
			{
				arrayCol=new ArrayCollection(array)
			}
			var comboxArray:*=arrayCol.toArray().slice(0);
			arrayCol=new ArrayCollection(comboxArray);
			var newObj:*={}
			newObj[field]="请选择"
			arrayCol.addItemAt(newObj, 0)
			return arrayCol
		}

		public static function findItemIndexInArray(array:*, field:*, value:*):*
		{
			if (array is Array)
			{
				array=new ArrayCollection(array)
			}
			for each (var it:* in array)
			{
				if (it[field] == value)
				{
//                  var ary:ArrayCollection=new ArrayCollection(array)
					return array.getItemIndex(it)
				}
			}
			return 0
		}

		/**
		 * 复制一个数组 并深度复制数组对象
		 * */
		public static function copyArrayItems(faryItems:*, parent:*):*
		{
			var laryNewItems:*=[]
			for each (var item:* in faryItems)
			{
				var newItem:*={}
				for (var field:* in item)
				{
					newItem[field]=item[field]
				}
				newItem.parent=parent
				laryNewItems.push(newItem)
			}
			return laryNewItems
		}

		/**
		 * 在数组集合中将oldField列复制一列命名为newField
		 * 参数：
		 *  dataArray  要转换的数据集合
		 *  oldField   要复制的字段名
		 *  newField   新字段名
		 * 例如：
		 *   ArrayCollUtils.addCopyFieldToArray(da,'personId','person');
		 *
		 * */
		public static function addCopyFieldToArray(dataArray:ArrayCollection, oldField:String, newField:String):void
		{
			for each (var item:Object in dataArray)
			{
				item[newField]=item[oldField];
			}
		}
		
		/**
		 * 保存时从表格中删除空记录
		 * */
		public static  function removeEmptyRowFromArray(faryItems:ArrayCollection,fstrIdField:String):void{
			for each(var item:Object in faryItems){
				if(!item[fstrIdField]){
					faryItems.removeItemAt(faryItems.getItemIndex(item));
				}
			}
		}
		
		
		/**
		 * 合并两个数组
		 * */
		public static function addArrayToArray(faryTarget:Array,farySource:Array):void{
			for each(var item:Object in farySource){
				faryTarget.push(item);
			}
		}
		

	}
}