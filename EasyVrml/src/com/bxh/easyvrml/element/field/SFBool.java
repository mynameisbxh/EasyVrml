package com.bxh.easyvrml.element.field;

import com.bxh.easyvrml.impl.FieldType;

/**
 * 单域值布尔型
 * 
 * @author BXH
 */
public class SFBool implements FieldType {
	
	private boolean boolValue;

	public SFBool(boolean boolValue) {
		this.boolValue = boolValue;
	}

	public boolean isBoolValue() {
		return boolValue;
	}

	public void setBoolValue(boolean boolValue) {
		this.boolValue = boolValue;
	}

	@Override
	public String getType() {
		return "SFBool";
	}

	@Override
	public Object getValue() {
		return boolValue;
	}
}
