package io.isoft.base.filter;

public class ObjectParameter {
	
	public String name;
	public Object value;
	public String fieldName;

	public ObjectParameter(String name, Object value, String fieldName){
		this.name = name;
		this.value = value;
		this.fieldName = fieldName;
	}
}
