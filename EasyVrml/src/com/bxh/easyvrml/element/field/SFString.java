package com.bxh.easyvrml.element.field;

import com.bxh.easyvrml.impl.FieldType;

public class SFString implements FieldType {
	private String sfStringValue;

	public String getSfStringValue() {
		return sfStringValue;
	}

	public void setSfStringValue(String sfStringValue) {
		this.sfStringValue = sfStringValue;
	}

	public SFString(String sfStringValue) {
		super();
		this.sfStringValue = sfStringValue;
	}

	@Override
	public String getType() {
		return "SFString";
	}

	@Override
	public Object getValue() {
		return sfStringValue;
	}
}
