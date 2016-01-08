package entity
{
/**
 * WebColumnClass VO.
 * @author Administrator
 * @Date 2015-07-13
 */
[Bindable]
[RemoteClass(alias='cn.vamos.reg.domain.WebColumnClass')]
public dynamic class WebColumnClass
{
	public var classCode:String;
	public var className:String;
	public var codeLevel:String;
	public var parentCode:String;
	public var endSign:String;
	public var phoInputCode:String;
	public var fiveInputCode:String;
	public var monitorSign:String;
	public var firstPageSign:String;
}
}
