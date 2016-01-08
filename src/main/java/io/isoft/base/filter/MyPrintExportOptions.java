package io.isoft.base.filter;

public class MyPrintExportOptions {

	private int pageTo;
	private int pageFrom;
	private String printExportOption;
	public MyPrintExportOptions(int pageTo, int pageFrom,
			String printExportOption) {
		super();
		this.pageTo = pageTo;
		this.pageFrom = pageFrom;
		this.printExportOption = printExportOption;
	}
	public MyPrintExportOptions() {
		super();
	}
	
	public int getPageTo() {
		return pageTo;
	}
	public void setPageTo(int pageTo) {
		this.pageTo = pageTo;
	}
	public int getPageFrom() {
		return pageFrom;
	}
	public void setPageFrom(int pageFrom) {
		this.pageFrom = pageFrom;
	}
	public String getPrintExportOption() {
		return printExportOption;
	}
	public void setPrintExportOption(String printExportOption) {
		this.printExportOption = printExportOption;
	}
	
}
