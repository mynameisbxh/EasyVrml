package com.bxh.easyvrml.element.field;

import com.bxh.easyvrml.impl.FieldType;

public class MFVec3f implements FieldType {

	private double[][] mfVec3fValue;

	public double[][] getMfVec3fValue() {
		return mfVec3fValue;
	}

	public void setMfVec3fValue(double[][] mfVec3fValue) {
		this.mfVec3fValue = mfVec3fValue;
	}

	public MFVec3f(double[][] mfVec3fValue) {
		super();
		this.mfVec3fValue = mfVec3fValue;
	}

	@Override
	public String getType() {
		return "MFVec3f";
	}

	@Override
	public Object getValue() {
		return mfVec3fValue;
	}
}
