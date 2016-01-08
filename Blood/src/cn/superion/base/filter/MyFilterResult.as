
package cn.superion.base.filter
{
	import mx.collections.ArrayCollection;
	[RemoteClass(alias="io.isoft.base.filter.MyFilterResult")] //this could be a class on the server

  	/**
  	 * A class that that our server sends us back with results
  	 */
  	public dynamic class MyFilterResult
	{
		public var records:ArrayCollection;
		public var totalRecords:Number;
	}
}