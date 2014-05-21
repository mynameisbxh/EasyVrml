package com.bxh.easyvrml.element.field;

import com.bxh.easyvrml.impl.FieldType;

public class MFVec2f implements FieldType {
	private double[] mfVec2fValue;

	public double[] getMfVec2fValue() {
		return mfVec2fValue;
	}

	public void setMfVec2fValue(double[] mfVec2fValue) {
		this.mfVec2fValue = mfVec2fValue;
	}

	public MFVec2f(double[] mfVec2fValue) {
		super();
		this.mfVec2fValue = mfVec2fValue;
	}

	@Override
	public String getType() {
		return "MFVec2f";
	}

	@Override
	public Object getValue() {
		return mfVec2fValue;
	}
}
