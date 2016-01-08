package entity
{
/**
 * MonitorWarnMaster VO.
 * @author Administrator
 * @Date 2015-07-13
 */
[Bindable]
[RemoteClass(alias='cn.vamos.reg.domain.MonitorWarnMaster')]
public dynamic class MonitorWarnMaster
{
	public var warnId:String;
	public var userCode:String;
	public var warnGrade:String;
	public var warnContent:String;
	public var readSign:String;
	public var createDate:Date;
}
}
