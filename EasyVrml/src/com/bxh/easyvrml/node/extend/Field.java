package com.bxh.easyvrml.node.extend;

import com.bxh.easyvrml.impl.FieldType;

public class Field {

	private String name;
	
	private FieldType type;

	public Field(String name, FieldType type) {
		this.name = name;
		this.type = type;
	}

	public String getFieldInfo(){
		String value = "";
		if(type.getType().equals("SFFloat")){
			value += type.getValue();
		}else if(type.getType().equals("SFColor")){
			double vs[] =  (double[])type.getValue();
			if(vs!=null){
				for(int i = 0;i<vs.length;i++){
					value+=(vs[i]+" ");
				}
			}
		}
		return type.getType() + " " + name + " " + value;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FieldType getType() {
		return type;
	}

	public void setType(FieldType type) {
		this.type = type;
	}
}
