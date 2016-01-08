package cn.superion
{
	import com.flexicious.components.tinycharts.valueobjects.HLOCSeries;
	
	public class ExtendedHLOCSeries extends HLOCSeries
	{
		public function ExtendedHLOCSeries()
		{
			super();
		}
		
		
		//----------------------------------
		//  additionalField1
		//----------------------------------
		
		/**
		 *  @private
		 *  Storage for the additionalField1 property.
		 */
		private var _additionalField1:String = "";
		
		[Inspectable(category="General")]
		
		/**
		 *  Specifies the field of the data provider that determines
		 *  the y-axis location of the additionalField1 value of the element. 
		 *
		 *  @default ""
		 */
		public function get additionalField1():String
		{
			return _additionalField1;
		}
		
		/**
		 *  @private
		 */
		public function set additionalField1(value:String):void
		{
			_additionalField1 = value;
		}
		
		
		//----------------------------------
		//  additionalField2
		//----------------------------------
		
		/**
		 *  @private
		 *  Storage for the additionalField1 property.
		 */
		private var _additionalField2:String = "";
		
		[Inspectable(category="General")]
		
		/**
		 *  Specifies the field of the data provider that determines
		 *  the y-axis location of the additionalField2 value of the element. 
		 *
		 *  @default ""
		 */
		public function get additionalField2():String
		{
			return _additionalField2;
		}
		
		/**
		 *  @private
		 */
		public function set additionalField2(value:String):void
		{
			_additionalField2 = value;
		}
		
		public var additionalField1Label:String =  "additionalField1Label\t: ";
		public var additionalField2Label:String = "additionalField2Label\t: ";
		
	}
}