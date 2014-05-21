package com.bxh.easyvrml.element.field;

import com.bxh.easyvrml.impl.FieldType;

public class MFRotation implements FieldType {

	private double[][] mfRotationValue;

	public double[][] getMfRotationValue() {
		return mfRotationValue;
	}

	public void setMfRotationValue(double[][] mfRotationValue) {
		this.mfRotationValue = mfRotationValue;
	}

	public MFRotation(double[][] mfRotationValue) {
		super();
		this.mfRotationValue = mfRotationValue;
	}

	@Override
	public String getType() {
		return "MFRotation";
	}

	@Override
	public Object getValue() {
		return mfRotationValue;
	}
}
