package cn.vamos.base.export
{
	import com.flexicious.export.ExportOptions;
	
	import mx.core.ClassFactory;
	[Bindable()]

	/**
	 * This is a class that extends the ExportOptions class. It is not required,
	 * but it gives you an opportunity to customize the export flow.
	 * In this example, we are adding our own version of the DocExporter to the list of 
	 * available exporters. By default the system provides word, excel, text, html exports. 
	 */
	public class MyExportOptions extends ExportOptions
	{
		public static function create(exporterIndex:int=0):MyExportOptions
		{
			var myExportOptions:MyExportOptions = new MyExportOptions();
			myExportOptions.enableLocalFilePersistence=true;
			myExportOptions.modalWindows=true
			myExportOptions.exporter = myExportOptions.exporters[exporterIndex]; 
			myExportOptions.exporters.push(new MyDocExporter());//we're adding our own exporter to the list
			myExportOptions.showColumnPicker=true;
			//myExportOptions.exportOptionsRenderer = new ClassFactory(MyExportOptionsRenderer);//we're creating a custom popup for the export options (Not needed, but availble) 
			return myExportOptions;
		}

	}
}

