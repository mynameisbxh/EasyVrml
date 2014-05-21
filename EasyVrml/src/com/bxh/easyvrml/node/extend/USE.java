package com.bxh.easyvrml.node.extend;

import com.bxh.easyvrml.impl.Node;

public class USE implements Node {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public USE(Node node) {
		this.name = Define.selectDefine(node);
	}
	
	public USE(String name) {
		if(Define.getNodeByName(name)==null){
			this.name = null;
		}else{
			this.name = name;
		}
	}
	
	public Node getNodeByName(String name){
		return Define.getNodeByName(name);
	}
	
	public String getUse(){
		return "USE " + name;
	}
}
