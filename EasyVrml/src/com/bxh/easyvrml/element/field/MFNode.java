package com.bxh.easyvrml.element.field;

import com.bxh.easyvrml.impl.FieldType;
import com.bxh.easyvrml.impl.Node;

public class MFNode implements FieldType {

	private Node[]	mfNodeValue;

	public MFNode(Node[] mfNodeValue) {
		super();
		this.mfNodeValue = mfNodeValue;
	}

	public Node[] getMfNodeValue() {
		return mfNodeValue;
	}

	public void setMfNodeValue(Node[] mfNodeValue) {
		this.mfNodeValue = mfNodeValue;
	}

	@Override
	public String getType() {
		return "MFNode";
	}

	@Override
	public Object getValue() {
		return mfNodeValue;
	}
}
