// ActionScript file

import com.flexicious.grids.dependencies.IDataGridFilterColumn;
import com.flexicious.grids.dependencies.IExtendedDataGrid;
import com.flexicious.grids.filters.FilterControlImpl;

		
protected var _filterControlInterface:FilterControlImpl;

public var rendererStyleName:String="";
private function rendererStyleCommitProperties():void{
	if(this.rendererStyleName.length>0)
		this.styleName= rendererStyleName;
}

/**
 * The field to search on, usually same as the data field. 
 * @return 
 * 
 */
public function get searchField():String{
	return filterControlInterface.searchField;
}
/**
 * @private 
 * @param o
 * 
 */
public function set searchField(o:String):void {
	filterControlInterface.searchField = o;
}

/**
 * The grid that the filter belogs to - can be null
 * if filter is used outside the grid 
 * @return 
 * 
 */
public function get grid():IExtendedDataGrid{
	return filterControlInterface.grid;
}
/**
 * @private 
 * @param o
 * 
 */
public function set grid(o:IExtendedDataGrid):void {
	filterControlInterface.grid = o;
}
/**
 * The grid column that the filter belogs to - can be null
 * if filter is used outside the grid 
 * @return 
 * 
 */
public function get gridColumn():IDataGridFilterColumn{
	return filterControlInterface.gridColumn;
}
/**
 * @private 
 * @param o
 * 
 */
public function set gridColumn(o:IDataGridFilterColumn):void {
	filterControlInterface.gridColumn = o;
}
/**
 * The filter operation to apply to the comparision
 * See the FilterExpression class for a list. 
 * see @com.flexicious.grids.filters.FilterExpression
 * 
 */
public function get filterOperation():String{
	return filterControlInterface.filterOperation;
}
[Inspectable(category="General", enumeration="Equals,NotEquals,BeginsWith,EndsWith,Contains,DoesNotContain,GreaterThan,LessThan,GreaterThanEquals,LessThanEquals,InList,NotInList,Between")]
		
/**
 * @private 
 * @param o
 * 
 */
public function set filterOperation(o:String):void {
	filterControlInterface.filterOperation= o;
}

/**
 * This is ususally automatically set, you dont have to manually set it,
 * unless you're sending strings as Date objects. When set, will attempt
 * to first convert the current value to the type you specified and then
 * do the conversion.
 * Values : auto,string,number,boolean,date
 * @default auto
 */	
public function get filterComparisionType():String{
	return filterControlInterface.filterComparisionType;
}
[Inspectable(category="General", enumeration = "auto,string,number,boolean,date")]

/**
 * @private 
 * @param o
 */
public function set filterComparisionType(o:String):void {
	filterControlInterface.filterComparisionType= o;
}
/**
 * @private 
 * @return 
 * 
 */
private function get filterControlInterface():FilterControlImpl
{
	if(_filterControlInterface==null)
		_filterControlInterface=new FilterControlImpl(this);
	return _filterControlInterface;
}
/**
 * The event that the filter triggers on. Defaults to "change", or if the 
 * filterRenderer supports com.flexicious.controls.interfaces.IDelayedChange, then
 * the delayedChange event.
 * @see com.flexicious.controls.interfaces.IDelayedChange
 */		
public function get filterTriggerEvent():String{
	return filterControlInterface.filterTriggerEvent;
}
[Inspectable(category="General", enumeration = "none,change,enterKeyUp")]
public function set filterTriggerEvent(o:String):void {
	filterControlInterface.filterTriggerEvent = o;
}

/**
 * Register with the container on creation complete 
 */
public function get autoRegister():Boolean
{
	return filterControlInterface.autoRegister;
}

/**
 * @private
 */
public function set autoRegister(value:Boolean):void
{
	filterControlInterface.autoRegister = value;
}
