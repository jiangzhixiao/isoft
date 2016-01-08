package entity{
	[Bindable]
	[RemoteClass(alias="cn.vamos.reg.domain.MonitorUsersConfig")]
	public dynamic class MonitorUsersConfig
	{
		public var autoId:String ;
		public var userCode:String ;
		public var columnCode:String ;
		
		public var columnName:String ;
		
		public var ruleId:String;
		
		public var ruleName:String ;
		
		public var useRange:String ;
		
		public var startTime:String ;
		
		public var monitorFrequency:Number;
		
		public var frequencyUnit:String ;
		
		public var operateTime:String ;
		
	}
}
