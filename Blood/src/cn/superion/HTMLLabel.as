package cn.superion
{ 
	import mx.controls.Label;

	public class HTMLLabel extends Label
	{
		public function HTMLLabel()
		{
			super();
		}
		
		public override function set text(val:String):void{
			super.htmlText = val;
		}
	}
}