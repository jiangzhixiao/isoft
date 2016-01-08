package cn.vamos.base
{
	import com.flexicious.controls.ComboBox;
	
	import flash.events.Event;
	
	import mx.events.FlexEvent;
	
	/**
	 * Inherit from the Flexicious filterable combobox, just 
	 * add a event listener to set the selected item when we 
	 * change the text, because the filtering mechanism looks
	 * for the selectedItem, not the text.
	 */	
	public class MyComboBox extends ComboBox
	{
		public function MyComboBox(){
			addEventListener(Event.CHANGE, onChange);
		}
		/**
		 * When the text changes, set the selected item,
		 * so filtering mechanism can pick it up. 
		 */		
		private function onChange(event:Event):void{
			for each(var item:Object in dataProvider){
				if((item.label == this.text) && (selectedItem!=item)){
					selectedItem=item;
				}
			}
		}

	}
}