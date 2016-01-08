package cn.superion
{
	import com.flexicious.components.charts.HLOCChart;
	import com.flexicious.components.charts.axis.IAxis;
	import com.flexicious.components.charts.painters.HLOCChartPainter;
	import com.flexicious.components.tinycharts.TinyChartBase;
	import com.flexicious.components.tinycharts.valueobjects.PlotPoint;
	import com.flexicious.components.tinycharts.valueobjects.Series;
	import com.flexicious.utils.UIUtils;
	
	import flash.display.CapsStyle;
	import flash.display.Graphics;
	import flash.display.JointStyle;
	import flash.display.LineScaleMode;
	import flash.display.Sprite;
	import flash.geom.Rectangle;
	
	public class ExtendedHLOCChartPainter extends HLOCChartPainter
	{
		public function ExtendedHLOCChartPainter(chart:TinyChartBase=null)
		{
			super(chart);
		}
		
		
		protected override function drawPlotPoints(xyPosData:Array, series:Series):void
		{
			var horizontalAxis:IAxis = cartesianChart.horizontalAxis;
			var verticalAxis:IAxis= cartesianChart.verticalAxis;
			var hlocSeries:ExtendedHLOCSeries = series as ExtendedHLOCSeries;
			var chartArea:Sprite=chartSkin.getChartSprite();
			var g:Graphics = chartArea.graphics;
			var width:Number=chartArea.width;
			var hdp:Object=chart.dataProvider;
			var hdpLen:Number=UIUtils.getLength(chart.dataProvider);
			var columnArea:Number = (width)/(Math.max(1,hdpLen));
			var hlocChart:HLOCChart = chart as HLOCChart;
			var columnBlock:Number = columnArea*hlocChart.columnWidthRatio;
			var columnWidth:Number = columnBlock/((hlocChart.type==TinyChartBase.CHART_VARTIAION_TYPE_CLUSTERED)?chart.visibleSeries.length:1);
			
			for each(var line:PlotPoint in xyPosData){ 
				var itemOpen:Number = UIUtils.resolveExpression(line.item, hlocSeries.openField) as Number;
				var itemClose:Number = UIUtils.resolveExpression(line.item, hlocSeries.closeField)as Number;
				var itemHigh:Number = UIUtils.resolveExpression(line.item, hlocSeries.highField) as Number;
				var itemLow:Number = UIUtils.resolveExpression(line.item, hlocSeries.lowField)as Number;
				
				var itemAdditionalField1:Number = UIUtils.resolveExpression(line.item, hlocSeries.additionalField1) as Number;
				var itemAdditionalField2:Number = UIUtils.resolveExpression(line.item, hlocSeries.additionalField2)as Number;
				
				
				
				var itemOpenY:Number = getVerticalAxis(itemOpen, verticalAxis);
				var itemCloseY:Number = getVerticalAxis(itemClose, verticalAxis);
				var itemHighY:Number = getVerticalAxis(itemHigh, verticalAxis);
				var itemLowY:Number = getVerticalAxis(itemLow, verticalAxis);
				var itemAdditionalField1Y:Number = getVerticalAxis(itemAdditionalField1, verticalAxis);
				var itemAdditionalField2Y:Number = getVerticalAxis(itemAdditionalField2, verticalAxis);
				
				
				line.rect = new Rectangle(line.xPos + (columnArea/2) - 8, itemHighY, columnWidth, Math.abs(itemLowY - itemHighY));
				g.lineStyle()
				g.beginFill(0xffffff,0.1);
				g.drawRect(line.rect.x,line.rect.y,line.rect.width,line.rect.height);
				g.endFill();
				
				var color:uint;
				
				if(itemOpen < itemClose)
					color = hlocSeries.getPositiveColor();
				else
					color = hlocSeries.getNegativeColor();
				g.lineStyle(hlocSeries.getLineThickness(),color,1, false, LineScaleMode.NORMAL, CapsStyle.SQUARE, JointStyle.MITER);
				
				g.moveTo(line.xPos + (columnArea/2) + 4, itemHighY);
				g.lineTo(line.xPos + (columnArea/2), itemHighY);
				
				g.moveTo(line.xPos + (columnArea/2) + 4, itemLowY);
				g.lineTo(line.xPos + (columnArea/2), itemLowY);
				
				
				g.moveTo(line.xPos + (columnArea/2) + 4, itemOpenY);
				g.lineTo(line.xPos + (columnArea/2), itemOpenY);
				
				g.moveTo(line.xPos + (columnArea/2), itemCloseY);
				g.lineTo(line.xPos + (columnArea/2) + 4, itemCloseY); 
				
				g.moveTo(line.xPos + (columnArea/2), itemAdditionalField1Y);
				g.lineTo(line.xPos + (columnArea/2) + 4, itemAdditionalField1Y); 
				
				g.moveTo(line.xPos + (columnArea/2), itemAdditionalField2Y);
				g.lineTo(line.xPos + (columnArea/2) + 4, itemAdditionalField2Y); 
				
				
			}
		}
		private function getVerticalAxis(value:Number, verticalAxis:IAxis):Number {
			return verticalAxis.height - (verticalAxis.height / (verticalAxis.tickEndValue - verticalAxis.tickStartValue)) * (value - verticalAxis.tickStartValue);
		}
	}
}