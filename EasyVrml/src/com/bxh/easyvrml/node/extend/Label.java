package com.bxh.easyvrml.node.extend;

public class Label {

	private String text;
	
	private double size;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Label(String text) {
		this(text,0.5);
	}
	
	public Label(String text,double size) {
		this.text = text;
		this.size = size;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}
}
