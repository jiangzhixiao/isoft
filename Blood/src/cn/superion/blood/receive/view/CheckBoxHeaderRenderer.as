package cn.superion.blood.receive.view
{
	import flash.events.MouseEvent;

	import mx.controls.CheckBox;

	public class CheckBoxHeaderRenderer extends CheckBox
	{
		//用于引用保存选中状态的外部属性
		public var stateHost:Object;
		public var stateProperty:String;

		/**
		 * 当数据setter方法被调用时，对传入的参数值(这个值是包含渲染器的DataGridColumn的引用)
		 * 是不做处理的，这个setter方法根据查看通过ClassFactory的properties属性中指定给渲染器
		 * 的外部标记变量来设置选中状态
		 * @param value
		 */
		override public function set data(value:Object):void
		{
			selected=stateHost[stateProperty];
		}

		/**
		 *根据点击事件后CheckBox的状态，再对外部标记变量进行设置,
		 * 以便与新选中的状态相匹配
		 * @param event
		 */
		override protected function clickHandler(event:MouseEvent):void
		{
			super.clickHandler(event);
			//用于更新保存状态的外部变量
			stateHost[stateProperty]=selected;
		}
	}
}