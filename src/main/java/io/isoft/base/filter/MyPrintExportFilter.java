package io.isoft.base.filter;


public class MyPrintExportFilter extends MyFilter {

	public MyPrintExportOptions printExportOptions;

	public MyPrintExportOptions getPrintExportOptions() {
		return printExportOptions;
	}

	public void setPrintExportOptions(MyPrintExportOptions printExportOptions) {
		this.printExportOptions = printExportOptions;
	}

	public MyPrintExportFilter(MyFilter filter) {
		super();
		this.printExportOptions = printExportOptions;
	}
	public MyPrintExportFilter() {
		super();
		this.printExportOptions = printExportOptions;
	}


}
