package cn.superion.base.filter
{
	import com.flexicious.grids.filters.FilterExpression;
	[RemoteClass(alias="io.isoft.base.filter.MyFilterExpression")] //this could be a class on the server
  	/**
  	 * A class that can be sent to the server with all the filter criteria, 
  	 * as opposed to sending it as individual parameters 
  	 */
  	public class MyFilterExpression
	{
		public var columnName:String;
        public var filterOperation:String = FilterExpression.FILTER_OPERATION_TYPE_EQUALS;
        public var expression:Object;
        
		/**
		* Initialize a remotable filterExpression from our the Flexicious filterExpression object.
		*/		
		public function MyFilterExpression(filterExpression:FilterExpression){
			
			this.columnName= filterExpression.columnName;
        	this.filterOperation= filterExpression.filterOperation;
        	this.expression = filterExpression.expression;
		}
	}
}