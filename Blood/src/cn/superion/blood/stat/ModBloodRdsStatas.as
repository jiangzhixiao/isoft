/**
 *		出入库统计模块
 *		author:吴小娟   2011.06.23
 *		checked by
 **/
import cn.superion.base.AppInfo;
import cn.superion.base.config.BaseDict;
import cn.superion.base.config.ParameterObject;
import cn.superion.base.util.ArrayCollUtils;
import cn.superion.base.util.DateUtil;
import cn.superion.base.util.FormUtils;
import cn.superion.base.util.PurviewUtil;
import cn.superion.base.RemoteUtil;
import cn.superion.main.treeMenu.MainFrameUtil;
import cn.superion.report2.ReportPrinter;
import cn.superion.report2.ReportViewer;

import flash.events.Event;
import flash.net.URLRequest;
import flash.net.URLStream;

import mx.collections.ArrayCollection;
import mx.controls.Alert;
import mx.events.FlexEvent;
import mx.events.ListEvent;
import mx.rpc.remoting.RemoteObject;

private const MENU_NO:String="0513";


/**
 * 查询功能
 * */
protected function btQuery_clickHandler(event:MouseEvent):void
{
	var selDate:String=txtDate.text;
	var param:ParameterObject=new ParameterObject();
	param.conditions={accMonth: selDate};
	var romote:RemoteObject=RemoteUtil.getRemoteObject('bloodRdsImpl', function(rev:Object):void
	{
		dgRdsStatList.dataProvider=rev.data;
	});
	romote.findRdsStatByCondition(param);
}

/**
 * @打印、输出功能...
 * 
 * @param 参数说明
 * 		  lstrPurview 权限编号;
 * 		  isPrint 打印输出标示,预览：2，打印：1，输出：0
 */
private function printExpHandler(lstrPurview:String,isPrint:String):void
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
	var laryWillPrintItems:ArrayCollection=null;
	laryWillPrintItems = dgRdsStatList.dataProvider as ArrayCollection;
	var dict:Dictionary = new Dictionary();
	dict["单位名称"] = AppInfo.sysUser.unitsName
//	dict["日期"] =DateField.dateToString( new Date(),'YYYY-MM-DD');
	dict["主标题"] = "血库出入库统计";
	dict["制表人"] =AppInfo.sysUser.userName;
	dict["月份"] = txtDate.text;
	var strXml:String = "report/blood/stat/bloodRdsStat.xml";
	loadReportXml(strXml,laryWillPrintItems,dict,isPrint);
//	if(isPrint == '1'){
//		ReportPrinter.LoadAndPrint("report/blood/stat/bloodRdsStat.xml", laryWillPrintItems, dict);
//	}else if(isPrint == '2'){
//		ReportViewer.Instance.Show("report/blood/stat/bloodRdsStat.xml", laryWillPrintItems, dict);
//	}
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
 * 返回主页面
 * */
protected function btReturn_clickHandler(event:MouseEvent):void
{
	MainFrameUtil.closeTab(this);
}

