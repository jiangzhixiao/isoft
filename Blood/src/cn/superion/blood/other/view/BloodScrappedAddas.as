import flash.events.Event;
import flash.events.MouseEvent;

private function deptCodeHandler(e:Event):void
{
	DictWinShower.showDeptDict(showItem)
}

protected function Doctor_clickHandler(e:Event):void
{
	DictWinShower.showDoctorDict(showIteme);
}

private function showItem(fItem:Object):void
{
	var showString:String="";
	for (var field:String in fItem)
	{
		if (field != "mx_internal_uid")
		{
			showString+=field + ":" + fItem[field] + "    ";
		}
	}
	//调供以下三个方法调用，根据模块要求选择其中的一种，一般选择填充方法调用
	//挷定方法调用
	//item=fItem;
	//填充方法调用
	//FormUtils.fillFormByItem(vgpTxt, fItem);
	//直接赋值调用
	deptCode.text=showString;
}

private function showIteme(fItem:Object):void
{
	var showString:String="";
	for (var field:String in fItem)
	{
		if (field != "mx_internal_uid")
		{
			showString+=field + ":" + fItem[field] + "    ";
		}
	}
	//调供以下三个方法调用，根据模块要求选择其中的一种，一般选择填充方法调用
	//挷定方法调用
	//item=fItem;
	//填充方法调用
	//FormUtils.fillFormByItem(vgpTxt, fItem);
	//直接赋值调用
	personId.text=showString;
}