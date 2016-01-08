package cn.vamos.base.export
{
	import com.flexicious.export.exporters.HtmlExporter;
	import com.flexicious.grids.dependencies.IExtendedDataGrid;

	public class Utf8ExcelExporter extends HtmlExporter
	{
		public function Utf8ExcelExporter()
		{
		}
		public override function get contentType():String{
			return "application/vnd.ms-excel"
		}
		public override function get extension():String{
			return "xls";	
		}
		public override function get name():String{
			return "Excel Export";
		} 		
		public override function writeHeader(grid:IExtendedDataGrid):String{
			return "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n<style>\n</style>\n</head>\n<body>\n"+ super.writeHeader(grid).replace("<table>","<table border=1>");
		}
		public override function writeFooter(grid:IExtendedDataGrid):String{
			return super.writeFooter(grid)+"\n</body>\n</html>";
		}
	}
}