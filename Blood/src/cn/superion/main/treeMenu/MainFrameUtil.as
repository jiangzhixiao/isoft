package cn.superion.main.treeMenu{

import cn.superion.base.AppInfo;
import cn.superion.main.view.TabPane;
	
	import flash.events.MouseEvent;
	
	import mx.collections.ArrayCollection;
	import mx.containers.TabNavigator;
	import mx.controls.HRule;
	import mx.modules.Module;
	
	import spark.components.BorderContainer;
	import spark.components.HGroup;
	import spark.components.VGroup;
	import spark.modules.ModuleLoader;
	
	import vamos.components.pane.Pane;
	import vamos.components.paneNavigators.tabPaneNavigator.TabPaneNavigator;

	public class MainFrameUtil
	{
		//linkUrl和tab页的map
		public static var gTabMap:Object={}
		//linkUrl和closeButton的map
		public static var gButtonMap:Object={}
		//linkUrl和toggleButton的map
		public static var gToggleButtonMap:Object={}
		public static var gModualMap:Object={}
		public static var gTreePanels:Array=[]
		public static var gMenuCon:VGroup
		public static var gMaxTabCount:int=6
		public static var gDefaultIcon:String="/assets/images/menu/document.png";
		public static function closeOldTab():void{
			var count:int=findObjectKeysCount();
			if(count>gMaxTabCount){
				closeOneTab()
			}
		}
		
		private static function closeOneTab():void{
			var closeButton:CloseButton;
			for(var field:Object in gButtonMap){
				closeButton=gButtonMap[field] as CloseButton
				if(closeButton.isRemoved){
					continue;
				}
				closeButton.close_clickHandler(null);
				return;
			}
		}
		
		private static function findObjectKeysCount():int{
			var count:int=0;
			for(var field:Object in gButtonMap){
				if(gButtonMap[field].isRemoved){
					continue;
				}
				trace(field)
				count++
			}
			return count;
			
		}
		/**
		 * ftreeData 菜单数据
		 * fmenuCon 垂直菜单
		 * fbuttonBar tab条
		 * fmainTabHost 主容器
		 * */
		public static function createMenu(ftreeData:Array,fmenuCon:VGroup,fbuttonBar:HGroup,fmainTabHost:TabPaneNavigator):void{
			gMenuCon=fmenuCon;
			var fnumWidth:Number=fmenuCon.width;
			gTreePanels=[]
			var index:int= 0;
			for each(var menuItem:Object in ftreeData){
				index ++;
				if(menuItem.children){
					var treeMenuPanel:TreePanel=new TreePanel();
					treeMenuPanel.height=25
					treeMenuPanel.width=fnumWidth
					treeMenuPanel.data = menuItem;
					treeMenuPanel.title=menuItem.label;
					treeMenuPanel.isRoot = index == 1?true:false; 
					treeMenuPanel.dataProvider=	menuItem.children
					treeMenuPanel.buttonBar=fbuttonBar?fbuttonBar:null
					treeMenuPanel.mainTabHost=fmainTabHost
					fmenuCon.addElement(treeMenuPanel);
					gTreePanels.push(treeMenuPanel)
					continue;
				}
				if(menuItem.linkUrl){
					var button:ToggleLinkButton=new ToggleLinkButton();
					button.label=menuItem.label
					button.linkTitle=menuItem.linkTitle
					button.width=fnumWidth
					button.height=25
					button.buttonIcon=menuItem.icon;
					button.linkTitle=menuItem.linkTitle
					button.linkUrl=menuItem.linkUrl
					button.userDefinedSign = menuItem.userDefinedSign;
					button.mainTabHost=fmainTabHost;
					button.menuNo = menuItem.menuNo;
					button.buttonBar=fbuttonBar?fbuttonBar:null
					fmenuCon.addElement(button);
					MainFrameUtil.gToggleButtonMap[button.linkUrl]=button;
				}
				if(menuItem.label=='-'){
					var line:HRule=new HRule();
					line.width=fnumWidth
					fmenuCon.addElement(line);
				}
			}
		}
		
		/**
		 *
		 * 打开一个tab页 
		 * @param moduleUrl
		 * 
		 */
		public static function openOneTab(moduleUrl:String):void
		{
			for(var url:String in MainFrameUtil.gToggleButtonMap)
			{
				if(url == moduleUrl)
				{
					var treePanel:TreePanel = MainFrameUtil.gToggleButtonMap[url].parentCon;
					if(treePanel.parentCon)
					{
						if(!treePanel.parentCon.isOpen)
						{
							treePanel.parentCon.image1_clickHandler(new MouseEvent(MouseEvent.CLICK));
							
						}
					}
					if(!treePanel.isOpen)treePanel.image1_clickHandler(new MouseEvent(MouseEvent.CLICK));
					
					MainFrameUtil.gToggleButtonMap[url].linkbutton1_clickHandler(new MouseEvent("click"));
					
				}
			}
		}
		
		public static function closeTab(module:Module):void
		{
			var nav:TabPaneNavigator = module.parentDocument.owner;
			var removedPane:TabPane =nav.selectedChild as TabPane;
			var removedIndex:int = nav.selectedIndex;
			var panes:ArrayCollection = nav.tabBarPart.dataProvider as ArrayCollection;
			panes.removeItem(removedPane);
			//				panes.removeItemAt(removedIndex);
			nav.removeElement(removedPane);
			var menu:ToggleLinkButton = MainFrameUtil.gToggleButtonMap[removedPane.menuNo];
			menu.clearSelected(true);
			MainFrameUtil.gTabMap[removedPane.menuNo] = null;
		}
		
		
		
		/**
		 * 获取菜单编号
		 **/
		public static function getMenuNo(module:Module):String{
			var url:String=ModuleLoader( module.owner).url
			for each(var item:Object in AppInfo.sysUser.dataViews){
				if(item.moduleDetail==url){
					return item.menuNo
				}
			}
			return "该菜单编号未能获取，请重新登录！";
		}
	}
}