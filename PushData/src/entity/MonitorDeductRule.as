package entity
{
/**
 * MonitorDeductRule VO.
 * @author Administrator
 * @Date 2015-07-13
 */
[Bindable]
[RemoteClass(alias='cn.vamos.reg.domain.MonitorDeductRule')]
public dynamic class MonitorDeductRule
{
	public var ruleId:String;
	public var ruleName:String;
	public var columnCode:String;
	public var columnName:String;
	public var indexCode:String;
	public var indexName:String;
	public var valveUnit1:String;
	public var valveY1:Number;
	public var valveR1:Number;
	public var valveUnit2:String;
	public var valveY2:Number;
	public var valveR2:Number;
	public var noSign:String;
	public var startTime:String;
	public var monitorFrequency:Number;
	public var frequencyUnit:String;
	public var operateTime:String;
	public var deductValue:Number;
	public var currentStatus:String;
}
}
