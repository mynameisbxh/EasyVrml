package com.bxh.easyvrml.element.field;

import com.bxh.easyvrml.impl.FieldType;

public class SFFloat implements FieldType {

	private double	sfFloatValue;

	public SFFloat(double sfFloatValue) {
		this.sfFloatValue = sfFloatValue;
	}

	public double getSfFloatValue() {
		return sfFloatValue;
	}

	public void setSfFloatValue(double sfFloatValue) {
		this.sfFloatValue = sfFloatValue;
	}

	@Override
	public String getType() {
		return "SFFloat";
	}

	@Override
	public Double getValue() {
		return sfFloatValue;
	}
}
