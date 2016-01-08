package cn.vamos.base.dateFormatCombo
{
	import com.flexicious.controls.DateComboBox;
	import com.flexicious.controls.interfaces.filters.IConverterControl;
	import com.flexicious.utils.DateRange;
	
	import mx.collections.ArrayCollection;

	/**
	 * Extends the base Date ComboBox, so we can
	 * provide our own format for the date popup 
	 */		
	public class MyDateComboBox extends DateComboBox implements IConverterControl 
	{
		//1) This shows how to modify the popup.
		public override function get  popup():Object
		{
			if(!_popup)_popup=new MyDatePicker();
				return _popup;
		}
		//2) This shows how to modify the date range option names
		public override function set dateRangeOptions(val:Array):void
		{
			//super.dateRangeOptions = val;
			
			var coll:ArrayCollection=new ArrayCollection();
			
			coll.addItem({"label":"Ontem","data":DateRange.DATE_RANGE_YESTERDAY});
			coll.addItem({"label":"Hoje","data":DateRange.DATE_RANGE_TODAY});
			coll.addItem({"label":"AmanhÃ£","data":DateRange.DATE_RANGE_TOMORROW});
			coll.addItem({"label":"MÃªs","data":DateRange.DATE_RANGE_THISMONTH});
			coll.addItem({"label":"Ano","data":DateRange.DATE_RANGE_THISYEAR});
			coll.addItem({"label":"Outra","data":DateRange.DATE_RANGE_CUSTOM});
			
			dataProvider = coll;
			coll.refresh();
			//coll.refresh();
		}
		
		//3) This shows how implement IConverterControl, which is something you would need
		//if your backend sends down strings for date values. XML data frequently has this problem.
		
		/*Use this function if your data is being fed to the grid in String format
		instead of actual date objects (This is the case in some web service implementations)
		If you implement IConverterControl, the 
		filtering mechanism will rely on your implementation of the convert method
		to determine equality or comparision. If you use this function, ensure that 
		you also implement IConverterControl. The function below demonstrates how
		you would parse dates if the value in the column is a date string in format 
		DD/MM/YYYY.  
		*/
		public function convert(val:String):Object
		{
			
			if(val.length>0)
			{
				var array:Array = val.split("/");
				if(array.length==3)
				{
					return new Date(Number(array[2]),Number(array[1]),Number(array[0]));
				}
				return null;	
			}
			return null;	
		}
		
	}
}