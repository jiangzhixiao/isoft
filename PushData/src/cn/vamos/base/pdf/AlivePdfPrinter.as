package cn.vamos.base.pdf
{
	import com.flexicious.controls.interfaces.IPDFPrinter;
	import com.flexicious.print.PrintOptions;
	import com.flexicious.print.printareas.PageSize;
	import com.flexicious.utils.UIUtils;
	
	import flash.display.DisplayObject;
	import flash.net.FileReference;
	import flash.utils.ByteArray;
	
	import mx.controls.Alert;
	import mx.events.CloseEvent;
	
	import org.alivepdf.layout.Size;
	import org.alivepdf.layout.Unit;
	import org.alivepdf.pages.Page;
	import org.alivepdf.pdf.PDF;
	import org.alivepdf.saving.Method;
	/**
	 * A class that takes the PDF Pages as they are generated. This functionality 
	 * was introduced in 2.9 to provide a responsive UI during the generation of the PDF. 
	 * Previously, the print controller created image snapshots in memory, and handed them all to the pdf engine, which processed
	 * them individually by adding them to the display tree in one go. 
	 * Instead, now, the step of the snapshot itself adds the image to the pdf doc and this whole thing
	 * runs inside a timer so the UI has an opportunity to update itself.
	 * 
	 * First, you specify a class that implements IPDFPrinter as the pdfPrinter property. 
	 * The AlivePdfPrinter is a sample implementation of IPDFPrinter. This class should expose the 
	 * methods defined in the IPDFPrinter which are used as such: 
	 * The beginDocument method is called when the Print controller is ready to send out the pages.
	 * For each page generated by the Print Controller, the addPage method is called.
	 * Once all pages are added to the doc, the endDocument method is called.
	 */	
	public class AlivePdfPrinter implements IPDFPrinter
	{
		private var pdfObject:PDF;
		
		public function addPage(flexPage:DisplayObject,printOptions:PrintOptions):void
		{
			var isLandscapse:Boolean=printOptions.pageSize.isLandscape;
			var page:Page=pdfObject.addPage();
			//now that we have the printed images in memory,
			//send them to alivepdf.
			var alivePdfSize:Size = Size.getSize(printOptions.pageSize.name);                    
			pdfObject.addImage(flexPage,null,0,0,alivePdfSize.mmSize[isLandscapse?1:0]-(20),
				alivePdfSize.mmSize[isLandscapse?0:1]-(20),0,1,false); //account for pdf page padding of 20 px
		}
		
		public function beginDocument(printOptions:PrintOptions):void
		{
			pdfObject = new PDF(printOptions.pageSize.isLandscape?PageSize.PAGE_LAYOUT_LANDSCAPE:
				PageSize.PAGE_LAYOUT_POTRAIT,Unit.MM,Size.getSize(printOptions.pageSize.name));
			
			
		}
		
		public function endDocument(printOptions:PrintOptions):void
		{
			saveDoc(printOptions);
		}
		
		private function saveDoc(printOptions:PrintOptions,confirmed:Boolean=false):void
		{
			if(!printOptions.asynch || confirmed){
			}else{
				UIUtils.showConfirm(printOptions.saveFileMessage,
					function(comp:Object,evt:CloseEvent):void{
						if(evt.detail==Alert.YES)
							saveDoc(printOptions,true)
					}
					,null,"File Download");	
				return;
			}
			//small script to echo back the bytes of the pdf, you may use the flexicious Echo,
			//but it is recommended that you implement this inside your own firewall for performance.
			//pdfObject.save( Method.REMOTE, "http://www.flexicious.com/Home/EchoPdf", "Report.pdf" );
			
			//For local persistence of PDF - uncomment this section and comment the line above.
			//Ensure that you are targeting Flash Player 10
			//You will also need to pull in the appropriate imports
			var fileReference:FileReference = new FileReference();
			var bytes:ByteArray = pdfObject.save(Method.LOCAL);
			fileReference.save(bytes, printOptions.pdfFileName);
			
			printOptions.printedPages.removeAll();//now that we're done, remove it from memory.
			
		}
		
	}
}