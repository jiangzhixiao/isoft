package cn.superion.base.export
{
	import com.flexicious.export.exporters.DocExporter;
	import com.flexicious.export.exporters.Exporter;
	import com.flexicious.grids.dependencies.IExtendedDataGrid;
	import com.flexicious.utils.UIUtils;
	/**
	 * A customized version of the doc exporter, that 
	 * adds custom header and footer data to the word 
	 * document that is generated.
	 */	
	public class MyDocExporter extends DocExporter
	{
		public function MyDocExporter()
		{
		}
		/**
		 * Writes the header. 
		 * @param grid
		 * @return 
		 * 
		 */		
		public override function writeHeader(grid:IExtendedDataGrid):String{
			return "<b>Employee List for My Company Name.</p> <p> Date Printed:"+UIUtils.formatDate(new Date())+"</b>" 
				+"<table style='background-color:whitesmoke'><tr>" + buildTh(grid) + "</tr>\r\n";
		}
		private function buildTh(grid:IExtendedDataGrid):String{
			
			var str:String="";
			var colIndex:int=0;
			for each(var col:Object in grid.getColumns()){
				str += "<th style='background-color:gainsboro;border: 1px silver solid;'>" + Exporter.getColumnHeader(col,colIndex++) + "</th>\r\n";
			}
			return str;
		}
		/**
		 * Writes each record 
		 * @param grid
		 * @param record
		 * @return 
		 * 
		 */		
		public override function writeRecord(grid:IExtendedDataGrid, record:Object):String{
			var str:String="<tr>\r\n";
			for each(var col:Object in grid.getColumns()){
				str += "<td style='border: 1px silver solid;'>" + col.itemToLabel(record)+ "</td>\r\n";
			}
			str += "</td>\r\n";
			return str;
		}
		/**
		 * Writes the footer. 
		 * @param grid
		 * @return 
		 * 
		 */		
		public override function writeFooter(grid:IExtendedDataGrid,dataProvider:Object):String{
			return "</table>\r\n" +
			"<b>Average Salary:"+UIUtils.formatCurrency(UIUtils.average(allRecords,"annualSalary"))+"</b>"
			+
			"<br/><b>Number of records:"+allRecords.length+"</b>" 
		}
		/**
		 * The name that shows up in the dropdown list box
		 * of exporters in the Export Options window. 
		 * @return 
		 * 
		 */		
		public override function get name():String{
			return "Custom Word Export";
		} 		

	}
}