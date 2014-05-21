package com.bxh.easyvrml.element.field;

import com.bxh.easyvrml.impl.FieldType;

public class SFTime implements FieldType {

	private long	sfTimeValue;

	
	public SFTime(long sfTimeValue) {
		this.sfTimeValue = sfTimeValue;
	}

	@Override
	public String getType() {
		return "SFTime";
	}

	@Override
	public Object getValue() {
		return sfTimeValue;
	}

	public long getSfTimeValue() {
		return sfTimeValue;
	}

	public void setSfTimeValue(long sfTimeValue) {
		this.sfTimeValue = sfTimeValue;
	}
}
