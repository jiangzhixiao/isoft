package cn.vamos.base
{
	
	import flash.net.URLRequest;
	import flash.net.navigateToURL;
	import flash.utils.setTimeout;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.managers.CursorManager;
	import mx.managers.PopUpManager;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.InvokeEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;

	public class RemoteUtil
	{
		
		public static var ENDPOINT:String="spring/messagebroker/amf";
		public static var CHANNEL_SET:String="spring/messagebroker/amf";
		public static var DESTINATION:String="userImpl";
		public function RemoteUtil()
		{
		}

		/**
		 *
		 * @功能：获取远程对象
		 * @参数： destination   String
		 *         fcallback Function 回调函数 参数rev.data是ArrayCollection
		 * @return 返回取得的远程对象
		 *
		 */
		public static function getRemoteObject(destination:String, fcallback:Function,faultCallback:Function=null):RemoteObject
		{
			CursorManager.setBusyCursor();
			var remote:RemoteObject=new RemoteObject();
			remote.destination=destination;
			remote.endpoint=ENDPOINT;
			//增加成功监听事件
			remote.addEventListener(ResultEvent.RESULT, function(e:ResultEvent):void
				{
					CursorManager.removeBusyCursor();

					var reV:Object=e.result;
					if (reV)
					{
//						if (reV.data && reV.data.source)
//						{
//							reV.data=new ArrayCollection(reV.data.source);
//						}
//						//
//						if (reV.data && reV.data.length == 1 && reV.data[0] is String)
//						{
//							var s:String
//							
//							if (reV.data[0].indexOf("[") == 0 && reV.data[0].indexOf("]") == reV.data[0].length-1)
//							{
//								try{
//									reV.data=JSON.parse(reV.data[0])
//								}catch(e:Error){
//								}
//							}
//
//						}
//						//
//						if (reV.data is Array)
//						{
//							reV.data=new ArrayCollection(reV.data)
//						}
						fcallback(reV)
					}
					else{
						if(faultCallback!=null)
						{
							faultCallback(reV);	
						}
						
						var lstrError:String=reV.error;

						if (lstrError.indexOf("could") > -1)
						{
							lstrError="服务端连接发生错误，可能数据库连接失败或加载程序失败！"
						}

						Alert.show(lstrError, "提示信息", 4, null, function():void
							{
								if (reV.action == '_expireSession_')
								{
									var url:String="";//StringUtils.getApplicationHtmlName();
									navigateToURL(new URLRequest(url), "_self");
								}

							});
					}
				});

			//增加失败监听器
			remote.addEventListener(FaultEvent.FAULT, function(e:FaultEvent):void
				{
				
					if(faultCallback!=null)
					{
						var reV:Object=e.fault;
						faultCallback(reV);	
					}
					
					CursorManager.removeBusyCursor();
					var errorMsg:String='';

					var errorSql:String=findSQLCause(e.fault);

					if (e.fault.faultDetail)
					{
						errorMsg=e.fault.faultDetail
					}
					else
					{
						var fault:Object=findRootCause(e.fault)

						if (fault.message)
						{
							if (fault.message && fault.message.length > 0)
							{
								errorMsg=fault.message
							}
						}
						else
						{
							errorMsg=fault.message
						}
					}

					errorMsg=errorSql + "错误：" + errorMsg
					if (errorMsg && errorMsg.indexOf('Channel.Connect.Failed error NetConnection') > -1)
					{
						errorMsg="网络连接或服务器程序失败"
					}
					Alert.show(errorMsg, "提示信息");
				});

			//
			return remote;
		}

		
		public  static function delayCallRemoteMethod(fun:Function):void{
			setTimeout(fun,200)
		}
		//查找服务端的错误信息
		private static function findRootCause(fault:Object):Object
		{
			while (true)
			{
				if (fault.rootCause)
				{
					fault=fault.rootCause
				}
				else
				{
					return fault
				}
			}
			return null;
		}

		//查找SQL错误原因
		private static function findSQLCause(fault:*):String
		{
			while (true)
			{
				if (fault.hasOwnProperty("SQL") && fault.SQL)
				{
					return "\nSQL：" + fault.SQL + "\n";
				}
				if ((fault.hasOwnProperty("cause") && fault.cause) || (fault.hasOwnProperty("rootCause") && fault.rootCause))
				{
					if (fault.hasOwnProperty("cause") && fault.cause)
					{
						fault=fault.cause;
					}
					else
					{
						fault=fault.rootCause;
					}
				}
				else
				{
					return "";
				}
			}
			return "";
		}
	}
}