import cn.superion.base.config.BaseDict;
import cn.superion.base.RemoteUtil;
import cn.superion.base.util.UploadRo;
import cn.superion.blood.receive.ModBorrowCenter;
import cn.superion.blood.receive.view.CheckBoxHeaderRenderer;
import cn.superion.blood.receive.view.DownloadRo;
import cn.superion.dataDict.DictWinShower;
import cn.superion.vo.blood.BloodRdsMaster;

import com.adobe.utils.StringUtil;

import flash.events.Event;
import flash.events.MouseEvent;

import mx.collections.ArrayCollection;
import mx.collections.ListCollectionView;
import mx.controls.Alert;
import mx.core.ClassFactory;
import mx.managers.PopUpManager;
import mx.rpc.remoting.mxml.RemoteObject;

private var _uploadObject:cn.superion.base.util.UploadRo=new cn.superion.base.util.UploadRo();
private var remoteObj:RemoteObject;
public var _parent:ModBorrowCenter;
public var unitsSelectAllFlag:Boolean=false;
private var _tempPersonId:String="";
private var _tempDeptCode:String="";
private var _this:*=this;
[Bindable]
private var importClassFactory:ClassFactory;

private function inita():void
{
	btUpload.addEventListener(MouseEvent.CLICK, upLoadClickHandler);
	btImp.addEventListener(MouseEvent.CLICK, impClickHandler);
	btSave.addEventListener(MouseEvent.CLICK, saveClickHandler);
	btReturn.addEventListener(MouseEvent.CLICK, winClose);
	btfileTemplete.addEventListener(MouseEvent.CLICK, downClickHandler);
	_uploadObject.isMultiUpload=true;
	_uploadObject.selectedCallback=upLoadCompleteHandler;

	//
	importClassFactory=new ClassFactory(CheckBoxHeaderRenderer);
	importClassFactory.properties={stateHost: this, stateProperty: 'unitsSelectAllFlag'};
	gridImpList.addEventListener(MouseEvent.CLICK, headerClickHandler);

}

/**
 * LabelFunction :根据成分编码显示成分名称,单位
 * */
private function labFunTypeCode(item:Object, column:DataGridColumn):String
{
	var valueAry:Array=[];
	var ary:ArrayCollection=BaseDict.bloodTypeDict;
	if (ary.length == 0)
	{
		return "";
	}
	var name:String="";
	var units:String="";
	for each (var obj:Object in ary)
	{
		if (obj.bloodType == item.typeCode)
		{
			name=obj.bloodTypeName;
			units=obj.units;
			valueAry.push(name);
			valueAry.push(units);
			break;
		}
	}
	return name;
}

/**
 * LabelFunction :根据成分编码显示成分名称,单位
 * */
private function labFunTypeCode1(item:Object, column:DataGridColumn):Array
{
	var valueAry:Array=[];
	var ary:ArrayCollection=BaseDict.bloodTypeDict;
	if (ary.length == 0)
	{
		return null;
	}
	var name:String="";
	var units:String="";
	for each (var obj:Object in ary)
	{
		if (obj.bloodType == item.typeCode)
		{
			name=obj.bloodTypeName;
			units=obj.units;
			valueAry.push(name);
			valueAry.push(units);
			break;
		}
	}
	return valueAry;
}

/**
 * LabelFunction :根据血型编码显示血型名
 * */
private function labFunBloodCode(item:Object, column:DataGridColumn):String
{
	var ary:ArrayCollection=BaseDict.bloodDict;
	if (ary.length == 0)
	{
		return " ";
	}
	var name:String="";
	for each (var obj:Object in ary)
	{
		if (obj.blood == item.bloodCode)
		{
			name=obj.bloodName;
		}
	}
	return name;
}

/**
 * LabelFunction :根据RH阴性：0，1，分别显示阳性，阴性
 * */
private function labFunRhSign(item:Object, column:DataGridColumn):String
{

	switch (item.rhSign)
	{
		case "0":
			return "阳性";
			break;
		case "1":
			return "阴性";
			break;
		default:
			return " ";
			break;
	}
}

/**
 * LabelFunction :显示序号
 * */
private function labFunSeriaNo(item:Object, column:DataGridColumn):int
{
	var ary:ArrayCollection=gridImpList.dataProvider as ArrayCollection;
	return ary.getItemIndex(item) + 1;

}

//
private function headerClickHandler(event:MouseEvent):void
{
	var mm:ArrayCollection=gridImpList.dataProvider as ArrayCollection;
	if (event.target is CheckBoxHeaderRenderer)
	{
		for each (var obj:Object in gridImpList.dataProvider)
		{
			obj.isSelected=CheckBoxHeaderRenderer(event.target).selected;
			ListCollectionView(gridImpList.dataProvider).itemUpdated(obj, "isSelected");
		}
	}
}

private function upLoadClickHandler(e:MouseEvent):void
{
	_uploadObject._fileDataArray=new Array();
	_uploadObject.pickfile(_parent.destination, "importBloodRds", this, null, "csv");
}

//上传文件
private function impClickHandler(e:MouseEvent):void
{
	if (filePath.text && filePath.text != '')
	{
		remoteObj=RemoteUtil.getRemoteObject(_parent.destination, function(rev:Object):void
			{
				gridImpList.dataProvider=rev.data;
				btSave.enabled=rev.success;
//					btSave.enabled = true;
			});
		remoteObj.getOperation("importBloodRds").send(_uploadObject._fileDataArray[0]);
	}
}

private function upLoadCompleteHandler(item:Object):void
{
	filePath.text=item.filename;
}

/**
 * 只保存选中的记录,规格 = 辅计量数量
 * */
private function saveClickHandler(e:MouseEvent):void
{
	//校验部门、经手人非空
	if (deptCode.text.length == 0 || personId.text.length == 0)
	{
		Alert.show('请填写部门、经手人', '提示');
		return;
	}
	var impList:ArrayCollection=gridImpList.dataProvider as ArrayCollection;
	if (impList && impList.length > 0)
	{
		var dataList:Array=new Array();
		var saveList:ArrayCollection=new ArrayCollection();
		for (var i:int=0; i < impList.length; i++)
		{
			var item:*=impList.getItemAt(i);
			item.assiAmount=item.spec;
			item.units="袋";
			item.totalCosts=item.tradePrice;
			item.totalCharges=item.retailPrice;
			var typeName:String=labFunTypeCode1(item, null)[0];
			//根据导入表格中的成分名称、返回成分编码和单位
			item.typeName=typeName;
			item.assiUnits=labFunTypeCode1(item, null)[1];
			var valId:String=StringUtil.trim(item.productCode);
			if (!item.productCode)
			{
				item.remark='产品码不能为空';
			}
			else if (item.productCode && item.productCode.length > 15)
			{
				item.remark='产品码输入有误';
			}
//			else if (!item.retailPrice)
//			{
//				item.remark='售价不能为空';
//			}
			else if (!item.tradePrice)
			{
				item.remark='进价不能为空';
			}
			else if (valId && valId.length != 13 && valId.length != 15)
			{
				item.remark='产品码应为13位或15位';   // 增加15位的血袋编号的录入   hjw     1-31
			}
			else if (item.productCode && item.bloodCode && item.typeCode && item.rhSign && item.spec && item.collectDate && item.availDate && item.remark != '保存成功' && item.isSelected)
			{
				item.idNoExist=false;
				saveList.addItem(item);
					//若选中，改变返回标识
//				returnflag = false;
			}
		}
		gridImpList.invalidateList();
		if (saveList && saveList.length > 0)
		{
			//获取主记录
			var it:BloodRdsMaster=new BloodRdsMaster();
			it.deptCode=_tempDeptCode;
			it.personId=_tempPersonId;
			it.remark=remark.text;
			remoteObj=RemoteUtil.getRemoteObject(_parent.destination, function(rev:Object):void
				{
					var ary:ArrayCollection=rev.data;
					gridImpList.dataProvider=ary;
					btSave.enabled=false;
					_parent.btQuery_clickHandler();
				});
//			remoteObj.saveData(it, saveList,false,false);
			remoteObj.save(it, saveList);
		}
	}
	else
	{
		Alert.show('请您选择要保存的信息!', '提示')
	}
}

//下载模板文件
private function downClickHandler(event:MouseEvent):void
{
	var downloadObj:DownloadRo=new DownloadRo(_parent.destination, "downloadExcelTemplate");
	downloadObj.doDownload(null, fileTemplete.text);
}

//关闭方法
private function winClose(e:MouseEvent):void
{
	PopUpManager.removePopUp(_this);
}

private function labelFunRemark(item:Object):String
{
	if (item.idNoExist)
	{
		return "已存在";
	}
	return "";
}

//部门档案字典
protected function dept_clickHandler(event:Event):void
{
	DictWinShower.showDeptDict(showItem);
}

//回调函数
private function showItem(fItem:Object):void
{
	deptCode.txtContent.text=fItem.deptName;
	_tempDeptCode=fItem.deptCode;

}

/**
 * 人员字典
 * */
protected function personId_clickHandler(event:Event):void
{
	DictWinShower.showPersonDict(function(item:Object):void
		{

			personId.txtContent.text=item.name;
			_tempPersonId=item.personId;
		});
}
