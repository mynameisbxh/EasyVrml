package com.bxh.easyvrml.element.field;

import com.bxh.easyvrml.impl.FieldType;

public class SFVec2f implements FieldType {
	private double[] sfVec2fValue;

	public double[] getSfVec2fValue() {
		return sfVec2fValue;
	}

	public void setSfVec2fValue(double[] sfVec2fValue) {
		this.sfVec2fValue = sfVec2fValue;
	}

	public SFVec2f(double[] sfVec2fValue) {
		super();
		this.sfVec2fValue = sfVec2fValue;
	}

	@Override
	public String getType() {
		return "SFVec2f";
	}

	@Override
	public Object getValue() {
		return sfVec2fValue;
	}
}
