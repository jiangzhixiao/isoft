package cn.superion.blood.util {
	import flash.events.Event;
	
	import mx.collections.ArrayCollection;
	import mx.controls.CheckBox;
	import mx.controls.DataGrid;
	import mx.controls.dataGridClasses.DataGridColumn;
	import mx.events.FlexEvent;
	
	public class CBoxIR extends CheckBox{
		
		public function CBoxIR() {
			super();
			this.addEventListener('change', changeHandler);
			this.addEventListener(FlexEvent.CREATION_COMPLETE,function(e:*):void{
//				selected=data.isSelected
			})		
		}
		
	    private var _data:Object;
	    override public function get data():Object {
	        return _data;
	    }
	    override public function set data(value:Object):void {
	        _data = value;
	        if(_data &&_data.hasOwnProperty("isSelected")&& _data['isSelected']){
	        	this.selected = true;
	        }else{
	        	this.selected = false;
	        }
	    }

		private function changeHandler(event:Event):void{
			if(data is DataGridColumn){
				selectAllRow()
				
				return
			}
			data.isSelected=this.selected
			
			_data['isSelected'] = this.selected;
			if(data.freezeSign=='1'){
				this.selected=false
				data.isSelected=false
				_data['isSelected'] = false
			}
		}
		private function selectAllRow():void{
			var currGrid:DataGrid=DataGrid(this.owner)
			var laryData:ArrayCollection = currGrid.dataProvider as ArrayCollection
			var lisSelected:Boolean=false;
			if(laryData.length>0){
				lisSelected=!laryData.getItemAt(0).isSelected
			}
			for each(var item:Object in laryData){
				item.isSelected=lisSelected
			}
			currGrid.invalidateList()
			currGrid.setFocus();
		}
	}
}