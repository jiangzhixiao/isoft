package cn.superion
{
	import com.flexicious.components.charts.HLOCChart;
	import com.flexicious.components.tinycharts.valueobjects.HLOCSeries;
	import com.flexicious.components.tinycharts.valueobjects.HitData;
	
	public class ExtendedHLOCChart extends HLOCChart
	{
		public function ExtendedHLOCChart()
		{
			super();
			painter = new ExtendedHLOCChartPainter(this); 
		}
		
		
		/**
		 * Datatip function
		 * @param item
		 * @return 
		 */		
		protected override function defaultDataTipFunction(hitData:HitData):String { 
			var s:ExtendedHLOCSeries = hitData.series as ExtendedHLOCSeries;
			var oitemLbl:String = s.openLabel;
			var citemLbl:String = s.closeLabel;
			var sitemLbl:String = s.highLabel;
			var litemLbl:String = s.lowLabel;
			var a1Lbl:String = s.additionalField1Label;
			var a2Lbl:String = s.additionalField2Label;
			return  (oitemLbl?oitemLbl :"") 
			+ hitData.series.dataFunction(hitData.chartItem.series, hitData.item, "openField")+ "\n"
				+ (citemLbl?citemLbl : "") 
				+ hitData.series.dataFunction(hitData.chartItem.series, hitData.item, "closeField")+ "\n" 
				+ (sitemLbl?sitemLbl : "") 
				+ hitData.series.dataFunction(hitData.chartItem.series, hitData.item, "highField")+ "\n"
				+ (litemLbl?litemLbl :"") 
				+ hitData.series.dataFunction(hitData.chartItem.series, hitData.item, "lowField")+ "\n"
				+ (a1Lbl?a1Lbl :"") 
				+ hitData.series.dataFunction(hitData.chartItem.series, hitData.item, "additionalField1")+ "\n"
				+ (a2Lbl?a2Lbl :"") 
				+ hitData.series.dataFunction(hitData.chartItem.series, hitData.item, "additionalField2")+ "\n";
		}
	}
}