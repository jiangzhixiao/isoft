
package cn.vamos.base.filter
{
	import mx.collections.ArrayCollection;
	[RemoteClass(alias="cn.vamos.base.filter.MyFilterResult")] //this could be a class on the server

  	/**
  	 * A class that that our server sends us back with results
  	 */
  	public class MyFilterResult 
	{
		public var records:ArrayCollection;
		public var totalRecords:Number;
	}
}