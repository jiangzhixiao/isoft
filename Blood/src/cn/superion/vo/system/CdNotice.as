package cn.superion.vo.system
{

	[Bindable]
	[RemoteClass(alias="io.isoft.system.domain.CdNotice")]

	public dynamic class CdNotice
	{
		public var noticeNo:String;
		public var unitsCode:String;
		public var noticeType:String;
		public var noticeDate:Date;
		public var noticeTitle:String;
		public var noticeContent:String;
		public var currentStatus:String;
		public var createPerson:String;
		public var createDate:Date;
		public var visibleSign:String;

		public function CdNotice()
		{
		}
	}
}