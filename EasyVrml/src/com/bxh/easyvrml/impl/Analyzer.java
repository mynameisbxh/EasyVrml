package com.bxh.easyvrml.impl;

import org.dom4j.Document;

import com.bxh.easyvrml.document.VrmlCodeStream;

public interface Analyzer {

	public VrmlCodeStream parseDocument(Document xmlDoc);
	
	public boolean checkDocument(Document xmlDoc);
	
}
