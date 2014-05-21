package com.bxh.easyvrml.element.field;

import com.bxh.easyvrml.impl.FieldType;

public class MFInt32 implements FieldType {
	private int[]	mfInt32Value;

	public int[] getMfInt32Value() {
		return mfInt32Value;
	}

	public void setMfInt32Value(int[] mfInt32Value) {
		this.mfInt32Value = mfInt32Value;
	}

	public MFInt32(int[] mfInt32Value) {
		super();
		this.mfInt32Value = mfInt32Value;
	}

	@Override
	public String getType() {
		return "MFInt32";
	}

	@Override
	public Object getValue() {
		return mfInt32Value;
	}
}
