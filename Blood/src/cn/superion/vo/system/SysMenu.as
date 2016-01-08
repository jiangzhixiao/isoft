package cn.superion.vo.system
{

	[Bindable]
	[RemoteClass(alias="io.isoft.system.domain.SysMenu")]

	public dynamic class SysMenu
	{
		public var menuNo:String;

		public var menuName:String;
		public var menuIcon:String;
		public var moduleSimple:String;
		public var moduleDetail:String;
		public var executeSign:String;
		public var userDefinedSign:String;
		public var logicValidate:String;
		public var serialNo:String;
		public var parentNo:String;
		public var remark:String;
		public var codeLevel:String;
		public var currentStatus:String;

		public function SysMenu()
		{
		}
	}
}