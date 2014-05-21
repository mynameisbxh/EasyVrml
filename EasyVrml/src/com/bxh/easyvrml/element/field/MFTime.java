package com.bxh.easyvrml.element.field;

import com.bxh.easyvrml.impl.FieldType;

public class MFTime implements FieldType {
	private long[]	mfTimeValue;

	public MFTime(long[] mfTimeValue) {
		super();
		this.mfTimeValue = mfTimeValue;
	}

	public long[] getMfTimeValue() {
		return mfTimeValue;
	}

	public void setMfTimeValue(long[] mfTimeValue) {
		this.mfTimeValue = mfTimeValue;
	}

	@Override
	public String getType() {
		return "MFTime";
	}

	@Override
	public Object getValue() {
		return mfTimeValue;
	}
}
