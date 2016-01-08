package cn.superion.base
{
	
	import flash.globalization.DateTimeStyle;
	
	import mx.charts.DateTimeAxis;
	import mx.formatters.CurrencyFormatter;
	import mx.formatters.DateFormatter;
	
	import spark.formatters.DateTimeFormatter;
	
	/**
	 * Utility class to handle most UI manipulations 
	 */	
	public class SampleUIUtils
	{
		public static function getRandom(minNum:Number,maxNum:Number):Number
		{
			return Math.ceil(Math.random() * (maxNum - minNum + 1)) + (minNum - 1);
		}
		/**
		 * 将日期型数据格式化
		 * @param
		 * @param
		 * @return Formatted date
		 */		
		public static function dataGridFormatDate(item:Object, column:Object):String
		{
			var dateFormatter:DateTimeFormatter = new DateTimeFormatter();
			dateFormatter.setStyle('locale','zh-CN');
//			dateFormatter.dateStyle = DateTimeStyle.SHORT;
//			dateFormatter.timeStyle = DateTimeStyle.LONG;
			//yyyy.MM.dd 如果为MMMM，则显示大写 如：十一月,增加一个a表示上下午
			//K:mm a:十二小时制 如：3:20 下午
			//k:mm a:二十四时制 如：15:20 下午
			dateFormatter.dateTimePattern = "yyyy.MM.dd HH:mm:ss";
			return dateFormatter.format(item[column.dataField]);
		}
		/**
		 * Formats the data in Currency format 
		 * @param item Item to format
		 * @param column Column that displays the property
		 * @return Formatted Currency
		 */		
		public static function dataGridFormatCurrency(item:Object, column:Object):String
		{
			var currencyFormatter:CurrencyFormatter = new CurrencyFormatter();
			//currencyFormatter.currencySymbol="£";
			return currencyFormatter.format(item[column.dataField]);
		}
		/**
		 * Formats the data in Currency format 
		 * @param item Item to format
		 * @param column Column that displays the property
		 * @return Formatted Currency
		 */		
		public static function dataGridFormatCurrencyWithCents(item:Object, column:Object):String
		{
			return currencyFormatterWithCents.format(item[column.dataField]);
		}
		
		public static function get currencyFormatterWithCents():CurrencyFormatter{
			var currencyFormatterWithCents:CurrencyFormatter = new CurrencyFormatter();
			currencyFormatterWithCents.precision=2;
			return currencyFormatterWithCents;
		}
		
		
	}
}