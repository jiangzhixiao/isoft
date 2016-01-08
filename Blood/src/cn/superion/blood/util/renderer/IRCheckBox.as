package cn.superion.blood.util.renderer
{
	import cn.superion.blood.util.SelectedComboBox;
	
	import flash.events.Event;
	import flash.events.MouseEvent;
	
	import mx.collections.ArrayCollection;
	import mx.controls.treeClasses.TreeListData;
	
	import spark.components.CheckBox;
	import spark.components.DataGroup;
	import spark.components.supportClasses.ItemRenderer;
	
	/**
	 * 
	 * @author jzx
	 * 
	 */	
	public class IRCheckBox extends ItemRenderer
	{
		private var _currentIndex:int
		private var _checkBox:CheckBox;
		public function IRCheckBox()
		{
			super();
		
		}
		
		
		
		/**
		 *  @private
		 */
		override protected function createChildren():void
		{
			super.createChildren();
			
			if (!_checkBox) 
			{
				_checkBox = new CheckBox;
				//此时无height属性，因为依赖于数据
//				_checkBox.labelDisplay.height ; 
			}
			
			_checkBox.addEventListener(MouseEvent.MOUSE_DOWN, checkBoxMouseDownHandler);
			_checkBox.addEventListener(MouseEvent.CLICK, checkBoxClickHandler);
			_checkBox.addEventListener(Event.CHANGE, checkBoxChangeHandler);
			addElement(_checkBox);
		}
		
		/**
		 *  @private
		 */
		override protected function measure():void
		{
			super.measure();
			
			if (isNaN(explicitWidth))
			{
				measuredWidth += _checkBox.width + 4;
//				measuredWidth = owner.width;
				measuredHeight = getExplicitOrMeasuredHeight();
			}
			else
			{
				if (_checkBox.measuredHeight > measuredHeight) 
					measuredHeight = _checkBox.measuredHeight;
			}
		}
		override protected function updateDisplayList(unscaledWidth:Number, unscaledHeight:Number):void{
			super.updateDisplayList(unscaledWidth,unscaledHeight);
			if(data){
//				var ss:Object = _checkBox.getStyle("fontSize");//默认是12号字体
				//curTarget.setStyle('color', "#0000ff");
//				_checkBox.labelDisplay.setStyle("fontSize","16");
//				this.owner.parent.height = _checkBox.height;
				_checkBox.label = data[(owner as SelectedComboBox).labelField] ;
				_checkBox.width = owner.width;
//				_checkBox.labelDisplay.top;
//				_checkBox.labelDisplay.;
				_checkBox.height = measuredHeight;
				_checkBox.selected = data.isSelected;
				_checkBox.setStyle('color',_checkBox.selected?"#0000ff":"#000000" );
			}
		}
		
		/**
		 * @private
		 */		
		protected function checkBoxClickHandler(event:MouseEvent):void
		{
			event.stopPropagation();
		}
		
		/**
		 * @private
		 */		
		protected function checkBoxChangeHandler(event:Event):void
		{
			var parentComboBox:SelectedComboBox = owner as SelectedComboBox;
			var selectedName:ArrayCollection = parentComboBox.cbxSelectedItemName;
			var selectedCode:ArrayCollection = parentComboBox.cbxSelectedItemCode;
			if(_checkBox.selected){
				data.isSelected=true;
				_checkBox.setStyle('color', "#0000ff");
				selectedName.addItem(data[parentComboBox.labelField]);
				if(selectedCode.contains(data[parentComboBox.labelFieldCode])){
					return;
				}
				selectedCode.addItem(data[parentComboBox.labelFieldCode]);
			}else{
				data.isSelected = false;
				_checkBox.setStyle('color', "#000000");
				if(selectedName.contains(data[parentComboBox.labelField])){
					selectedName.removeItemAt(selectedName.getItemIndex(data[parentComboBox.labelField]));
					selectedCode.removeItemAt(selectedCode.getItemIndex(data[parentComboBox.labelFieldCode]));
				}
//				for (var i:int=0;i<selectedName.length;i++){
//					if(selectedName[i] == data[parentComboBox.labelField]){
//						selectedName.removeItemAt(i);
//						i--;
//					}
//				}
			}
			parentComboBox.textInput.text = selectedName.toArray().join(',');
			
		}
		/**
		 * @private
		 */		
		protected function checkBoxMouseDownHandler(event:MouseEvent):void
		{
			event.stopPropagation();	
		}
		
	}
}