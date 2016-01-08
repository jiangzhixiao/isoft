package cn.superion.base
{
	import flash.events.MouseEvent;
	import flash.filters.ColorMatrixFilter;
	
	import mx.controls.Image;

	/**
	 * Just a simple image button based off of
	 * http://cookbooks.adobe.com/post_Convert_images_to_grayscale_using_ActionScript_-12769.html
	 */
	[Style(name="overBorderColor", type="color", inherit="no")]
	public class ImageButton extends Image
	{
		private var over:Boolean=false;

		public function ImageButton()
		{
			super();
			buttonMode=true;
			addEventListener(MouseEvent.MOUSE_OVER, onMouseOver);
			addEventListener(MouseEvent.MOUSE_OUT, onMouseOut);
			addEventListener(MouseEvent.CLICK,onClick);
		}

		private function onMouseOver(event:MouseEvent):void
		{
			if (enabled)
			{
				over=true;
				invalidateDisplayList();
			}
		}

		private function onMouseOut(event:MouseEvent):void
		{
			if (over)
			{
				over=false;
				invalidateDisplayList();
			}
		}
		
		private function onClick(event:MouseEvent):void
		{
			if (!enabled)
			{
				event.stopImmediatePropagation();
				return ;
			}
		}

		override protected function updateDisplayList(w:Number, h:Number):void
		{
			super.updateDisplayList(w, h);
			graphics.clear();
			if (over)
			{
				var color:uint=getStyle("overBorderColor") as uint;
				if(!color){
					color=0x000000;
				}
				
				graphics.lineStyle(1, color, 1);
				graphics.drawRect(-1, -1, contentWidth + 1, contentHeight + 1);
			}
		}

		public override function set enabled(val:Boolean):void
		{
			super.enabled=val;
			if (!enabled)
			{
				this.filters=new Array(new ColorMatrixFilter([0.3, 0.59, 0.11, 0, 0, 0.3, 0.59, 0.11, 0, 0, 0.3, 0.59, 0.11, 0, 0, 0, 0, 0, 1, 0]));
			}
			else
				this.filters=new Array();
			this.buttonMode=enabled;
		}

	}
}

