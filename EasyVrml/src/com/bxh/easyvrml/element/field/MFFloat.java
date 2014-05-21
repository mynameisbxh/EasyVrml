package com.bxh.easyvrml.element.field;

import com.bxh.easyvrml.impl.FieldType;

public class MFFloat implements FieldType {

	private double[] mfFloatValue;

	public double[] getMfFloatValue() {
		return mfFloatValue;
	}

	public void setMfFloatValue(double[] mfFloatValue) {
		this.mfFloatValue = mfFloatValue;
	}

	public MFFloat(double[] mfFloatValue) {
		super();
		this.mfFloatValue = mfFloatValue;
	}

	@Override
	public String getType() {
		return "MFFloat";
	}

	@Override
	public Object getValue() {
		return mfFloatValue;
	}
}
