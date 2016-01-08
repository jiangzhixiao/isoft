package cn.vamos.base.dynamicFilter
{
	/**
	 * Represents a Filter operation.
	 */	
	 [Bindable()]
	public class OperationData
	{
		public function OperationData(data:String,label:String,isListExpression:Boolean,expressionCount:int=-1)
		{
			this.data=data;
			this.label=label;
			this.isListExpression = isListExpression;
			this.expressionCount=expressionCount;
		}
		public var data:String;
		public var label:String;
		public var isListExpression:Boolean=false;
		public var expressionCount:int=-1;
	}
}