package com.bxh.easyvrml.document;

public class VrmlCodeStream {
	
	private StringBuffer content;
	
	public VrmlCodeStream(){
		content = new StringBuffer();
	}

	public StringBuffer getContent() {
		return content;
	}

	public void setContent(StringBuffer content) {
		this.content = content;
	}
}
