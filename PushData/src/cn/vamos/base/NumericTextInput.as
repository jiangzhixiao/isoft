package cn.vamos.base
{
	import com.flexicious.controls.TextInput;
	import com.flexicious.controls.interfaces.filters.IDynamicFilterControl;
	import com.flexicious.grids.filters.FilterExpression;
	

	public class NumericTextInput extends TextInput implements IDynamicFilterControl
	{
		public function NumericTextInput()
		{
			super();
			restrict="0-9";
		}
		
		
		public  function get filterExpression():FilterExpression{
			if(text.length>0){
				var f:FilterExpression = new FilterExpression();
				f.columnName=searchField;
				f.filterOperation = filterOperation;
				f.expression = parseInt(text);
				return f;
			}
			return null;
		} 
	}
}