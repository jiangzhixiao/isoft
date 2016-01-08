/**
 *		工作量统计模块
 *		author:吴小娟   2011.06.23
 *		checked by
 **/
import cn.superion.base.AppInfo;
import cn.superion.base.config.BaseDict;
import cn.superion.base.config.GridColumn;
import cn.superion.base.config.ParameterObject;
import cn.superion.base.util.ArrayCollUtils;
import cn.superion.base.util.FormUtils;
import cn.superion.base.util.PurviewUtil;
import cn.superion.base.RemoteUtil;
import cn.superion.main.treeMenu.MainFrameUtil;
import cn.superion.dataDict.DictWinShower;
import cn.superion.report2.ReportPrinter;
import cn.superion.report2.ReportViewer;

import com.adobe.utils.StringUtil;
import com.as3xls.xls.ExcelFile;
import com.as3xls.xls.Sheet;

import flash.net.FileReference;
import flash.utils.ByteArray;

import flexlib.scheduling.util.DateUtil;

import mx.collections.ArrayCollection;
import mx.controls.Alert;
import mx.events.CloseEvent;
import mx.events.FlexEvent;
import mx.events.ListEvent;
import mx.managers.PopUpManager;
import mx.rpc.remoting.mxml.RemoteObject;

private var _visitDept:String = "";
private var _visitDoctor:String = "";
private const MENU_NO:String = "0512";
//服务类接口
private var destination:String = "workLoadStatImpl";


/**
 * 初始化
 * */
protected function doInit():void
{
	
	gridStockList.sumItemCallBack = function(item:Object):void{
		item._assiUnits=item._assiUnits ? item._assiUnits : "";
		item.assiAmount=item.assiAmount+item._assiUnits;
		item.assiAmount=item.assiAmount == '0' ? "" : item.assiAmount;
		item.spec=item._assiUnits?'共'+item.itemCount+'项':"";
	}

}

/**
 * 回车事件
 * */
protected function keyUpCtrl(event:KeyboardEvent, ctrl:Object):void
{
	if (event.keyCode == 13)
	{
		if (ctrl.className == "DateField")
		{
			ctrl.open();
		}
		ctrl.setFocus();
	}
}

/**
 * 查询按钮
 * */
protected function btQuery_clickHandler():void
{
	var params:Object = FormUtils.getFields(queryPanelTi, []);
	params["beginDate"] = dfStartDate.selectedDate;
	params["endDate"] = addOneDay(dfEndDate.selectedDate);
	params["visitDept"] = StringUtil.trim(wardCode.txtContent.text).length == 0 ? null :  _visitDept;
	params["visitDoctor"] = StringUtil.trim(personId.txtContent.text).length == 0 ? null : _visitDoctor;
	var paramQuery:ParameterObject = new ParameterObject();
	paramQuery.conditions = params;
	
	var ro:RemoteObject = RemoteUtil.getRemoteObject(destination, function(rev:Object):void
	{
		if(rev.data && rev.data.length > 0)
		{
			gridStockList.dataProvider=rev.data[0];
			gridStockList.height=gridStockList.parent.height-2;
			gridStockList.invalidateSize();
			gdItemList.dataProvider=rev.data[1];
		}
		
	});
	ro.findByCondition(paramQuery);
}

/**
 * 给指定日期+(24*3600*1000-1000);
 * */
private function addOneDay(date:Date):Date{
	return DateUtil.addTime(new Date(date), DateUtil.DAY_IN_MILLISECONDS - 1000);
}

/**
 * 回车实现查找功能
 * */
private function keUpHandler(e:KeyboardEvent):void
{
	if(!btQuery.enabled){
		return;
	}	
	if (e.keyCode == Keyboard.ENTER)
	{
		btQuery_clickHandler();
	}
}

/**
 * 打印、预览处理事件
 * @param 参数说明
 * 		  lstrPurview 权限编号;
 * 		  isPrintSign 打印输出标示,预览：2，直接打印：1，输出：0
 */
protected function btPreview_clickHandler(lstrPurview:String, isPrintSign:String):void
{
	//判断具有操作权限  -- 应用程序编号，菜单编号，权限编号
	// 01：增加                02：修改            03：删除
	// 04：保存                05：打印            06：审核
	// 07：弃审                08：输出            09：输入
	if (!PurviewUtil.getPurview(AppInfo.APP_CODE, MENU_NO, lstrPurview))
	{
		Alert.show("您无此按钮操作权限！", "提示");
		return;
	}
	var rawArray:ArrayCollection=gridStockList.dataProvider as ArrayCollection;
	if(rawArray == null || rawArray.length == 0){
		return;
	}
//	var rawArray:ArrayCollection=gridStockList.rawDataProvider as ArrayCollection;
	var lastItem:Object=rawArray.getItemAt(rawArray.length-1);	
	var _dataList:ArrayCollection=gridStockList.dataProvider as ArrayCollection;
	var laryGroups:Array=ArrayCollUtils.changeToGroupArray(_dataList, gridStockList.groupField, ['assiAmount'], "typeName");
	var _testItemDataList:ArrayCollection=gdItemList.dataProvider as ArrayCollection;
	var dict:Dictionary = new Dictionary();
	dict["单位名称"] = AppInfo.sysUser.unitsName;
	dict["日期"] = DateField.dateToString(new Date(), 'YYYY-MM-DD');
	dict["出库日期"] = DateField.dateToString(dfStartDate.selectedDate, 'YYYY-MM-DD');
	
	dict["主标题"] = "工作量统计";
	dict["制表人"] = AppInfo.sysUser.userName;
	var strXml:String = "";
	if(isPrintSign == '1')
	{
		if(tab.selectedIndex==0)
		{
			strXml = "report/blood/stat/workLoadStat.xml";
//			ReportPrinter.LoadAndPrint("report/blood/stat/workLoadStat.xml", rawArray, dict);
		}
		else
		{
			strXml = "report/blood/stat/workLoadStat2.xml";
//			ReportPrinter.LoadAndPrint("report/blood/stat/workLoadStat2.xml", _testItemDataList, dict);

		}
	}
	else
	{
		if(tab.selectedIndex==0)
		{
			strXml = "report/blood/stat/workLoadStat.xml";
//			ReportViewer.Instance.Show("report/blood/stat/workLoadStat.xml", rawArray, dict);
		}
		else
		{
			strXml = "report/blood/stat/workLoadStat2.xml";
//			ReportViewer.Instance.Show("report/blood/stat/workLoadStat2.xml", _testItemDataList, dict);
		}
	}
	
	loadReportXml(strXml,rawArray,dict,isPrintSign);
}

private function loadReportXml(reportUrl:String,faryDetails:ArrayCollection, fdict:Dictionary,fprintSign:String):void{
	var loader:URLStream=new URLStream();
	loader.addEventListener(Event.COMPLETE, function(event:Event):void{
		var stream:URLStream = event.currentTarget as URLStream;
		var xml:XML=XML(stream.readMultiByte(stream.bytesAvailable,"utf-8"));
		if (fprintSign == "1")
		{
			ReportPrinter.Print(xml, faryDetails, fdict);
		}
		else
		{
			ReportViewer.Instance.Show(xml, faryDetails, fdict);
		}
	});
	var url:URLRequest = new URLRequest(reportUrl);
	loader.load(url);
}

/**
 * 病区字典：点击
 * */
protected function wardCode_queryIconClickHandler():void
{
	var x:int=0;
	var y:int=this.parentApplication.screen.height - 345;
	DictWinShower.showDeptWardDict((function(item:Object):void
	{
		wardCode.txtContent.text=item.deptName;
		_visitDept=item.deptCode;
		//						_visitDept=item.deptCode;
	}));
}
/**
 * 人员字典：点击
 * */
protected function personId_queryIconClickHandler():void
{
	var x:int=0;
	var y:int=this.parentApplication.screen.height - 345;
	DictWinShower.showPersonDict((function(item:Object):void
	{
		personId.txtContent.text=item.personIdName;
		_visitDoctor=item.personId;
		//						_visitDept=item.deptCode;
	}));
}

/**
 * 输出
 * */
protected function btExport_clickHandler(lstrPurview:String, isPrintSign:String):void
{
	//判断具有操作权限  -- 应用程序编号，菜单编号，权限编号
	// 01：增加                02：修改            03：删除
	// 04：保存                05：打印            06：审核
	// 07：弃审                08：输出            09：输入
	if (!PurviewUtil.getPurview(AppInfo.APP_CODE, MENU_NO, lstrPurview))
	{
		Alert.show("您无此按钮操作权限！", "提示");
		return;
	}
	expExcel()
	
}

private function expExcel():void{
	var laryGroupData:Array=gridStockList.groupDataProvider as Array
	var cols:Array=gridStockList.columns
	var excelFile:ExcelFile = new ExcelFile();
	var sheet:Sheet = new Sheet();
	if(gridStockList.dataProvider == null){
		return;
	}
	sheet.resize(gridStockList.dataProvider.length+laryGroupData.length+1,cols.length)
	addExcelHeader(gridStockList,sheet);
	addExcelData(laryGroupData,sheet);
	excelFile.sheets.addItem(sheet);
	var mbytes:ByteArray = excelFile.saveToByteArray();
	var  file:FileReference=new FileReference()
	file.save(mbytes,"blood.xls")
	
}

private function addExcelHeader(gridStockList:Object,fsheet:Sheet):void{
	var cols:Array=gridStockList.columns
	var i:int=0;
	for each(var col:GridColumn in cols){
		fsheet.setCell(0,i,col.headerText)
		i++
	}
}

private function addExcelData(laryGroupData:Array,fsheet:Sheet):void{
	var lintRow:int=1;
	var cols:Array=gridStockList.columns
	for each(var lgroup:Object in laryGroupData){
		for each(var litem:Object in lgroup.list){
			fsheet.setCell(lintRow,0,lgroup.key)
			lgroup.key=''
			fsheet.setCell(lintRow,1,litem[cols[1].dataField]||'')
			fsheet.setCell(lintRow,2,litem[cols[2].dataField]||'')
			fsheet.setCell(lintRow,3,litem[cols[3].dataField]||'')
			lintRow++;
		}
	}
}

/**
 * 返回主页面
 * */
protected function btReturn_clickHandler(event:MouseEvent):void
{
	MainFrameUtil.closeTab(this);
}