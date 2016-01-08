package cn.vamos.base.print
{
	import com.flexicious.print.PrintOptions;
	import com.flexicious.utils.UIUtils;
	
	import mx.core.ClassFactory;

	/**
	 *  This is a class that extends the basic print options
	 *  Demonstrates all the features of the print framework 
	 * that can be customized.
	 * 
	 * Please note : This class is optional, only use it 
	 * if you need to customize the default print behavior 
	 *  
	 */
	public class MyPrintOptions extends PrintOptions
	{
		[Bindable()]
		public var reportTitle:String;
		public static function create(reportTitle:String='',reportSubTitle:String=''):MyPrintOptions
		{
			//We can customize the overall page settings.
			//This is just a VBOX and you can set any 
			//supported style properties.
			var myPrintOptions:MyPrintOptions=new MyPrintOptions();
			myPrintOptions.windowStyleProperties["paddingTop"]="10";
			myPrintOptions.windowStyleProperties["paddingBottom"]="10";
			myPrintOptions.windowStyleProperties["paddingLeft"]="10";
			myPrintOptions.windowStyleProperties["paddingRight"]="10";
			
			
			//newly added to 2.9
			//myPrintOptions.asynch=true;

			//set the renderers for report header, footer, page header and footer
			//to our classes so we can customize the look and feel of the 
			//various components of the print. 
			
			//for the header, we create a parmeterized
			myPrintOptions.reportHeaderRenderer=UIUtils.createRenderer(MyReportHeader,{reportSubHeader:reportSubTitle})
			myPrintOptions.reportFooterRenderer=new ClassFactory(MyReportFooter);

			myPrintOptions.pageHeaderRenderer=new ClassFactory(MyPageHeader);
			myPrintOptions.pageFooterRenderer=new ClassFactory(MyPageFooter);
			//customize the print preview and print options screen by
			//plugging in our own implementations.
			myPrintOptions.printOptionsViewrenderer=new ClassFactory(MyPrintOptionsRenderer);
			myPrintOptions.printPreviewViewrenderer=new ClassFactory(MyPreviewRenderer);
			
			myPrintOptions.reportTitle = reportTitle;

			return myPrintOptions;

		}

	}
}

