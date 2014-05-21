package com.bxh.easyvrml.element.field;

import com.bxh.easyvrml.impl.FieldType;

public class SFInt32 implements FieldType {
	private int	sfInt32Value;

	public int getSfInt32Value() {
		return sfInt32Value;
	}

	public void setSfInt32Value(int sfInt32Value) {
		this.sfInt32Value = sfInt32Value;
	}

	public SFInt32(int sfInt32Value) {
		super();
		this.sfInt32Value = sfInt32Value;
	}

	@Override
	public String getType() {
		return "SFInt32";
	}

	@Override
	public Object getValue() {
		return sfInt32Value;
	}
	
}
