package com.bxh.easyvrml.element.field;

import com.bxh.easyvrml.impl.FieldType;

public class SFRotation implements FieldType {
	private double[] sfRotationValue;

	public double[] getSfRotationValue() {
		return sfRotationValue;
	}

	public void setSfRotationValue(double[] sfRotationValue) {
		this.sfRotationValue = sfRotationValue;
	}

	public SFRotation(double[] sfRotationValue) {
		super();
		this.sfRotationValue = sfRotationValue;
	}

	@Override
	public String getType() {
		return "SFRotation";
	}

	@Override
	public Object getValue() {
		return sfRotationValue;
	}
}
