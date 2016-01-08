package cn.superion.blood.receive.view
{
	import cn.superion.base.RemoteUtil;
	
	import flash.events.Event;
	import flash.events.MouseEvent;
	import flash.net.FileReference;
	
	import mx.controls.Alert;
	import mx.rpc.remoting.mxml.RemoteObject;
	
    /**
    * 下载文件
    * 用法：
    *   var downloadObj:DownloadRo=new DownloadRo(destination,method);
    *   downloadObj.doDownload({fileId:'00001'},'xxxx.doc')
    * */
	public class DownloadRo
	{
		private var fileRef:FileReference=new FileReference();
		private var _method:String = null;
		private var _destination:String = " ";
        public function DownloadRo(fstrDestination : String,fstrMethod : String){
        	this._method=fstrMethod
        	this._destination=fstrDestination
        }
        public function set method(fstrMethod:String):void{
        	this._method=fstrMethod
        }
        public function set destination(fstrDestination:String):void{
        	_destination=fstrDestination
        }        
		public function doDownload(fparam:Object,fstrFileName : *=null):void
		{
			var ro:RemoteObject=RemoteUtil.getRemoteObject(_destination, function(rev:Object):void
				{
					var fileData:*=rev.data[0]
					if(fstrFileName == null){
						if(rev.data.length>1){
							fstrFileName=rev.data[1]
						}else{
							fstrFileName = ""
						}						
					}
					Alert.show("下载完成，要保存到您的计算机中吗？", "提示", Alert.YES | Alert.NO, null, function(e:*):void
						{
							if (e.detail == Alert.YES)
							{
								var fileReference:FileReference=new FileReference();
								fileReference.save(fileData, fstrFileName);
							}
						})
				})
			if(!fparam){
				ro.getOperation(_method).send()
			}else{
			    ro.getOperation(_method).send(fparam)
			}
		}
	}
}