package cn.superion.blood.util
{
	import cn.superion.base.util.LoadModuleUtil;
	
	import com.as3xls.xls.ExcelFile;
	import com.as3xls.xls.Sheet;
	
	import flash.net.FileReference;
	import flash.utils.ByteArray;
	
	import mx.collections.ArrayCollection;
	import mx.collections.IViewCursor;
	import mx.controls.DateField;
	import mx.controls.dataGridClasses.DataGridColumn;
	import mx.core.ClassFactory;
	import mx.core.FlexGlobals;
	import mx.modules.ModuleLoader;
	import mx.utils.ObjectUtil;
 
	public class DefaultPage
	{
//		public static var lookType:String=null;
//		public static var queryInpNo:String=null;
		public static var  isLinkApply:Boolean=false;
		
		public function DefaultPage()
		{
		}

		//回到缺省主页面，供各分模块中的返回调用
		public static function gotoDefaultPage():void
		{
			var url:String='cn/superion/blood/main/view/ModMainRight.swf';
			LoadModuleUtil.loadCurrentModule(ModuleLoader(FlexGlobals.topLevelApplication.mainWin.mainFrame), url, FlexGlobals.topLevelApplication.mainWin.modPanel);
		}

		/**
		 * 向下翻页，到最后一条时，再从第一条开始往下翻
		 * @param cursor 当前集合的双向枚举集合视图的接口
		 * @param loop 循环标示."true":循环在已有的数据集合中滚动
		 * */
		public static function pageDown(cursor:IViewCursor,loop:Boolean):Object{
			var _obj:Object = null;
			if (!cursor.afterLast)
			{
				if(cursor.bookmark.getViewIndex() == -1){
//					cursor.moveNext();
					cursor.moveNext();
					_obj =cursor.current
				}else{
					_obj =  cursor.current;
				}
				cursor.moveNext();
			}else{
				if(loop){
					cursor.seek(cursor.bookmark,cursor.view.length*-1+1,0);
					_obj =  cursor.current;
					cursor.moveNext();
				}
			}
			return _obj;
		}
		/**
		 * 向上翻页
		 * @param cursor 当前集合的双向枚举集合视图的接口
		 * @param loop 循环标示."true":循环在已有的数据集合中滚动
		 * */
		public static function pageUp(cursor:IViewCursor,loop:Boolean):Object{
			var _obj:Object = null;
			if (!cursor.beforeFirst)
			{
				if(cursor.bookmark.getViewIndex() == -1){
//					cursor.movePrevious();
					cursor.movePrevious();
					_obj =cursor.current
				}else{
					_obj =  cursor.current;
				}
				cursor.movePrevious();
			}else{
				if(loop){
					cursor.seek(cursor.bookmark,cursor.view.length-1,0);
					_obj =  cursor.current;
					cursor.movePrevious();
				}
			}
			return _obj;
		}
		
		/**
		 *  类型转换.
		 *  @param item 传入的对象.通常是字典数据.
		 *  @param targetClass 要转成的对象.
		 * */
		public static function classTransfer(item:Object,targetClass:*):*{
			var propertyNames:Array = ObjectUtil.getClassInfo(targetClass,null,null).properties;
			for each (var qname:QName in propertyNames){
				var property:String = qname.localName;
				if(item.hasOwnProperty(property))
					targetClass[property] = item[property];
				else
					targetClass[property] = isNaN(targetClass[property])?0:targetClass[property];
			}
			return targetClass;
		}
		/**
		 *  将集合的数据类型转为指定类型.
		 *  @param aryCol 传入的集合.
		 *  @param targetClass 要转成的类型.
		 * */
		public static function aryColTransfer(aryCol:ArrayCollection,targetClass:*):ArrayCollection{
			var newAry:ArrayCollection = new ArrayCollection();
			for each(var item:* in aryCol ){
				var classFactory :ClassFactory = new ClassFactory(targetClass);
				var instance:Object = classFactory.newInstance()
				classTransfer(item,instance);
				newAry.addItem(instance);
			}
			return newAry;
			
		}
		
		public static function exportExcel(dataGridName:Object,rptHeaderName:String):void{
			
			var laryDataList:ArrayCollection=new ArrayCollection();
			var cols:Array=[];
			var excelFile:ExcelFile = new ExcelFile();
			var sheet:Sheet = new Sheet();
			laryDataList = dataGridName.dataProvider as ArrayCollection;
			cols=dataGridName.columns;
			sheet.resize(dataGridName.dataProvider.length+1,cols.length);
			addExcelHeader(dataGridName,sheet);
			addExcelData(laryDataList,sheet,dataGridName);
			excelFile.sheets.addItem(sheet);
			var mbytes:ByteArray = excelFile.saveToByteArray();
			var  file:FileReference=new FileReference();
			var _currentDate:String=DateField.dateToString(new Date(),'YYYY-MM-DD');
			var excelTitle:String=rptHeaderName+_currentDate;
			file.save(mbytes,excelTitle+".xls");
		}
		public static function addExcelHeader(dataList:Object,fsheet:Sheet):void{   
			var cols:Array=dataList.columns;	
			var i:int=0;
			for each(var col:* in cols){
				if(col.dataField){
					fsheet.setCell(0,i,col.headerText);
					i++;
				}
			}
		}
		
		public static function addExcelData(laryDataList:ArrayCollection,fsheet:Sheet,gridName:Object):void{
			var lintRow:int=1;
			var cols:Array=gridName.columns;
			for each(var litem:Object in laryDataList){
				var lintColumn:int = 0;
				var index:int =0;
				for each(var col:DataGridColumn in cols){
//					fsheet.setCell(lintRow,0,lintRow ||'');
					if(litem[cols[index].dataField] is Date)
						fsheet.setCell(lintRow,lintColumn,DateField.dateToString(litem[cols[index].dataField],'YYYY-MM-DD'));
					else
						fsheet.setCell(lintRow,lintColumn,litem[cols[index].dataField]|| '');
					index++;
					lintColumn ++;
				}
				lintRow ++;
			}
			
		}
	}
}