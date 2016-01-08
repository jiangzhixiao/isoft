package cn.vamos.base
{
	public class SystemConstants
	{
//		public static const hours:Array = [{"OPERATE_TIME":"08:00"},{"OPERATE_TIME":"09:00"},{"OPERATE_TIME":"10:00"},
//			{"OPERATE_TIME":"11:00"},{"OPERATE_TIME":"12:00"},{"OPERATE_TIME":"13:00"},{"OPERATE_TIME":"14:00"},
//				{"OPERATE_TIME":"15:00"},{"OPERATE_TIME":"16:00"},{"OPERATE_TIME":"17:00"},{"OPERATE_TIME":"18:00"},
//					{"OPERATE_TIME":"19:00"},{"OPERATE_TIME":"20:00"},{"OPERATE_TIME":"21:00"},{"OPERATE_TIME":"22:00"}];
//		
		public static const hours:Array = ["08:00","09:00","10:00",
			"11:00","12:00","13:00","14:00",
			"15:00","16:00","17:00","18:00",
			"19:00","20:00","21:00","22:00"];
		
		public static const ranges:Array = [{"code":"01","rname":"栏目扣分细则"},{"code":"02","rname":"栏目"},{"code":"03","rname":"用户"}];
		public static const units:Array = [{"code":"01","uname":"小时"},{"code":"02","uname":"天"}];
		
		
		public function SystemConstants()
		{
		}
	}
}