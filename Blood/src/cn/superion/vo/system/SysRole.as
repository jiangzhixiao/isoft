package cn.superion.vo.system
{


import mx.collections.ArrayCollection;

import org.apache.flex.collections.ArrayList;

[Bindable]
	[RemoteClass(alias="io.isoft.system.domain.SysRole")]

	public dynamic class SysRole
	{
		public var roleCode:String;
		public var roleName:String;
		public var shareIndic:String;
        public var menus:ArrayCollection;
		public function SysRole()
		{
		}
	}
}