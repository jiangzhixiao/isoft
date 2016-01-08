package cn.superion.blood.deliver.view
{
	import cn.superion.base.util.FormUtils;
	import cn.superion.base.RemoteUtil;
	
	import com.adobe.utils.StringUtil;
	
	import mx.rpc.remoting.RemoteObject;

	public class PriceListUtil
	{
		public function PriceListUtil()
		{
		}
		/**
		 * des:目标
		 * method:方法
		 * code:字典中的编码，如输血品种字典、则code为type_code；如检验项目字典、则code为item_code
		 * field:根据哪个字段进行提取
		 * _spec:规格，可为空
		 * fun:回调函数，形如：function(o:Object){}。其o实际对应HIS库中：CURRENT_PRICE_LIST对象
		 * */
		public static function TakeItemPrice(des:String,method:String, code:String, _spec:String,field:String,fun:Function):void{
			//获取HIS_CODE
			takeHisCode(des,method, code,_spec,field,fun);
		}
		protected static function takeHisCode(des:String,method:String,code:String,_spec:String,field:String,fun:Function):void {
			var ro :RemoteObject = RemoteUtil.getRemoteObject(des,function(o:Object):void{
				if (!o||o.data.length==0)return;
				//处理规格,成分字典中红细胞的单位为u，需转成对应的毫升，才能找出价表中对应的价格
				if(o.data[0][field]=="1204-6-18"
					||o.data[0][field]=="1204-6-10"
					||o.data[0][field]=="H1.005"
					||o.data[0][field]=="H1.014")
				{
					_spec = (Number(_spec) * 200).toString();
				}
				//根据hiscode、辅计数量、单位找价格
					returnPrice('hisBaseDictImpl','findItemPriceByCondition',o.data[0][field],_spec,fun);
			});
			ro.getOperation(method).send(code);
		}
		protected static function returnPrice(des:String,method:String,hisCode:String, _spec:String, callback:Function):void{
			var ro :RemoteObject = RemoteUtil.getRemoteObject(des,function(o:Object):void{
				callback.call(this,o);
			});
			ro.getOperation(method).send(hisCode,_spec,"like");
		}
	}
}