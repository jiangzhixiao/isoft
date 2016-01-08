package cn.superion.vo.system
{
import mx.collections.ArrayCollection;

import org.apache.flex.collections.ArrayList;

[Bindable]
	[RemoteClass(alias="io.isoft.system.domain.SysUser")]
	/**
	 *
	 * 系统登录用户相关信息
	 *
	 */
	public dynamic class SysUser
	{
		public var userCode:String;
		public var userName:String;
		public var unitsCode:String;
		public var unitsName:String; // 扩充：单位名称

		public var deptCode:String;
		public var deptName:String;
		public var subDeptCode:String;
		public var subDeptName:String;
		
		public var password:String;
		public var inputCode:String="PHO_INPUT";
		public var state:String="1";
		public var freezeSign:String;
		public var createDate:Date;

		// 用户对应人员档案中的ID
		public var personId:String;
		// 用户对应人员档案中的身份证号
		public var idNo:String;
		// 角色授权菜单数据权限

		// 授权科室列表
		public var deptList:ArrayCollection;

		//当前登录的角色
		public var roleCode:String;
		//当前程序版本号
		public var appVersion:String;

		// 11.07.27处方权限、职称
		// 12.06.03修改
//		public var recPurview:String;
//		public var technicalPost:String;
//		
		// 职称级别
		public var technicalPostLevel:String;
		// 医务人员
		public var dnSign:String;

		public var myPatient:String

		//Custom add
		public var isSelected:Boolean=false;
		public var roles:ArrayCollection;
		public var userRoles:ArrayCollection ;
		public function SysUser()
		{
		}
	}
}
