package cn.superion.blood.util
{
	import cn.superion.blood.util.renderer.IRCheckBox;
	
	import flash.events.Event;
	import flash.events.MouseEvent;
	
	import mx.collections.ArrayCollection;
	import mx.core.ClassFactory;
	import mx.events.FlexEvent;
	
	import spark.components.ComboBox;
	import spark.events.DropDownEvent;
	
	public class SelectedComboBox extends ComboBox
	{
		private var _ddFactory:ClassFactory;
		private var _isTextSpan:Boolean;
		private var _editable:Boolean;
		/**
		 * 提交于的字段值，通常用于in关联查询使用
		 * */
		private var _labelFieldCode:String;
		
		/**
		 * 设置项目渲染器 
		 */		
		private function get ddFactory():ClassFactory 
		{ 
			if (_ddFactory == null) 
			{ 
				_ddFactory = new ClassFactory(); 
				_ddFactory.generator = IRCheckBox; 
			} 
			return _ddFactory;       
		}    
		
		
		/**
		 * 选中项的数组(通过CheckBox选择的项目) 
		 */		
		private var _cbxSelectedItems:ArrayCollection = new ArrayCollection;
		public var cbxSelectedItemName:ArrayCollection = new ArrayCollection(); //名称
		public var cbxSelectedItemCode:ArrayCollection = new ArrayCollection();//编码
		public function set cbxSelectedItems(array:ArrayCollection):void
		{
			if (array)
			{
				_cbxSelectedItems = array;
//				dispatchEvent(new ListEvent("treeChange")); 
			}
		}
		public function get cbxSelectedItems():ArrayCollection
		{
			return _cbxSelectedItems;
		}
		
		
		public function set editable(val:Boolean):void{
				_editable = val;
		}
		
		public function set isTextSpan(val:Boolean):void{
			_isTextSpan = val;
		}
		/**
		 * 提交给后台的字段值，通常用于in关联查询使用
		 * */
		public function set labelFieldCode(str:String):void
		{
			this._labelFieldCode = str;
		}
		public function get labelFieldCode():String
		{
			return _labelFieldCode;
		}
		
		public function SelectedComboBox()
		{
			super(); 
			
			this.itemRenderer = ddFactory; 
			selectedIndex = -1;
//			this.addEventListener(FlexEvent.VALUE_COMMIT, selectedComboBox_valueCommitHandler);

		}
		/**
		 * 组件初始化完成
		 * */
		override protected function initializationComplete():void{
			super.initializationComplete();
			this.textInput.addEventListener(MouseEvent.MOUSE_DOWN,textInput_mouseDownHandler);
						this.textInput.addEventListener(MouseEvent.MOUSE_UP,textInput_mouseUpHandler);
			this.textInput.editable = _editable;
		}
		
		/**
		 * @private
		 */		
		protected function selectedComboBox_closeHandler(event:DropDownEvent):void
		{
			trace(event.cancelable)
			event.preventDefault();
		}
		
		/**
		 * @private
		 */		
		protected function selectedComboBox_valueCommitHandler(event:DropDownEvent):void
		{
			trace(event.cancelable)
			event.preventDefault();
		}
		/*
		
		/** 
		 * private
		 */ 
		override protected function updateDisplayList(unscaledWidth:Number,  
													  unscaledHeight:Number):void  
		{  
			super.updateDisplayList(unscaledWidth, unscaledHeight);    
			
		}
		
		private var aryIndicatorIndex:Array = [0];//用于存放 分隔符 的数组 ，默认第一个是0，
		private var aryIndex:Array = [];//当每次点击时，会计算出当前合适的索引
		private var selectionAnchorIndex:int = 0;//存放当前光标所在位置
		private function findAryIndex():Array{
			for (var i:int =0;i<aryIndicatorIndex.length-1;i++){
				if(selectionAnchorIndex >= aryIndicatorIndex[i] && selectionAnchorIndex<=aryIndicatorIndex[i+1]){
					aryIndex.push(aryIndicatorIndex[i],aryIndicatorIndex[i+1]);
					return aryIndex;
				}
			}
			return null;
		}
		private function finddStartIndexByReg(reg:RegExp,value:String):Array{
			var result:Array = reg.exec(value);
			if(reg.lastIndex >0){
				aryIndicatorIndex.push(reg.lastIndex);
				finddStartIndexByReg(reg,value);
			}
			else{
				aryIndicatorIndex.push(value.length);
			}
			return aryIndicatorIndex;
		}
		
		protected function textInput_mouseDownHandler(event:MouseEvent):void
		{
			if(_isTextSpan){
				
			selectionAnchorIndex = event.currentTarget.selectionAnchorPosition;
			var reg:RegExp = /,/g;
			finddStartIndexByReg(reg,this.textInput.text);
			aryIndex = findAryIndex();
			var anchorIndex:int = aryIndex[0];
			var activeIndex:int = aryIndex[1];
			this.textInput.selectRange(anchorIndex,activeIndex);
			}
			
		}
		protected function textInput_mouseUpHandler(event:Event):void
		{
			// TODO Auto-generated method stub
			super.mouseUpHandler(event);
			if(_isTextSpan){
				aryIndicatorIndex = [0];
				aryIndex = [];	
			}
		}
		
	}
}