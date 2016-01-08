package entity
{
/**
 * MonitorWarnDetail VO.
 * @author Administrator
 * @Date 2015-07-13
 */
[Bindable]
[RemoteClass(alias='cn.vamos.reg.domain.MonitorWarnDetail')]
public dynamic class MonitorWarnDetail
{
	public var recordId:String;
	public var warnId:String;
	public var ruleId:String;
	public var columnCode:String;
	public var indexCode:String;
	public var deductReason:String;
	public var deductValue:Number;
	public var operateTime:String;
	public var createDate:Date;
	public var noSign:String;
	public var warnGrade:String;
}
}
