package com.bxh.easyvrml.element.field;

import com.bxh.easyvrml.impl.FieldType;

public class MFString implements FieldType {

	private String[]	mfStringValue;

	public String[] getMfStringValue() {
		return mfStringValue;
	}

	public void setMfStringValue(String[] mfStringValue) {
		this.mfStringValue = mfStringValue;
	}

	public MFString(String[] mfStringValue) {
		super();
		this.mfStringValue = mfStringValue;
	}

	@Override
	public String getType() {
		return "MFString";
	}

	@Override
	public Object getValue() {
		return mfStringValue;
	}
}
