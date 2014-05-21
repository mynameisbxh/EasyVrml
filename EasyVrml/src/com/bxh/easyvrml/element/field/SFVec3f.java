package com.bxh.easyvrml.element.field;

import com.bxh.easyvrml.impl.FieldType;

public class SFVec3f implements FieldType {

	private double[][] sfVec3fValue;

	public SFVec3f(double[][] sfVec3fValue) {
		super();
		this.sfVec3fValue = sfVec3fValue;
	}

	public double[][] getSfVec3fValue() {
		return sfVec3fValue;
	}

	public void setSfVec3fValue(double[][] sfVec3fValue) {
		this.sfVec3fValue = sfVec3fValue;
	}

	@Override
	public String getType() {
		return "SFVec3f";
	}

	@Override
	public Object getValue() {
		return sfVec3fValue;
	}
}
