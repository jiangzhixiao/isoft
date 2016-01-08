
package cn.superion.base.filter
{
	import com.flexicious.grids.filters.FilterSort;
	[RemoteClass(alias="io.isoft.base.filter.MyFilterSort")] //this could be a class on the server
  	/**
  	 * A class that can be sent to the server with all the filter criteria, 
  	 * as opposed to sending it as individual parameters 
  	 */
  	public class MyFilterSort
	{
		public var sortColumn:String;
		public var isAscending:Boolean;
		/**
		* Initialize a remotable filterSort from our the Flexicious filterSort object.
		*/		
		public function MyFilterSort(filterSort:FilterSort){
			
			this.sortColumn= filterSort.sortColumn;
        	this.isAscending= filterSort.isAscending;
		}
	}
}