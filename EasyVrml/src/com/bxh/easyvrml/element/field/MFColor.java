package com.bxh.easyvrml.element.field;

import com.bxh.easyvrml.impl.FieldType;

public class MFColor implements FieldType {
	private double[][] mfColorValue;

	public double[][] getMfColorValue() {
		return mfColorValue;
	}

	public void setMfColorValue(double[][] mfColorValue) {
		this.mfColorValue = mfColorValue;
	}

	public MFColor(double[][] mfColorValue) {
		super();
		this.mfColorValue = mfColorValue;
	}

	@Override
	public String getType() {
		return "MFColor";
	}

	@Override
	public Object getValue() {
		return mfColorValue;
	}
}
