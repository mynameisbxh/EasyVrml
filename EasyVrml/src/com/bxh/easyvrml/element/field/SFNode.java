package com.bxh.easyvrml.element.field;

import com.bxh.easyvrml.impl.FieldType;
import com.bxh.easyvrml.impl.Node;

public class SFNode implements FieldType {

	private Node sfNodeValue;

	public SFNode(Node sfNodeValue) {
		super();
		this.sfNodeValue = sfNodeValue;
	}

	public Node getSfNodeValue() {
		return sfNodeValue;
	}

	public void setSfNodeValue(Node sfNodeValue) {
		this.sfNodeValue = sfNodeValue;
	}

	@Override
	public String getType() {
		return "SFNode";
	}

	@Override
	public Object getValue() {
		return sfNodeValue;
	}
}
