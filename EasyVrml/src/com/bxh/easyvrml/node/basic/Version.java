package com.bxh.easyvrml.node.basic;

import com.bxh.easyvrml.impl.Node;

/**
 * Version 用于表示Document的版本信息
 * @author BXH
 */
public class Version implements Node{
	
	private double version_id;		//版本号
	private String encoding;		//字符集
	
	public Version() {
		this(2.0,"utf8");		//默认版本号为2.0 字符集为UTF-8 
	}

	/**
	 * @param version_id	版本号
	 * @param encoding	文档编码
	 */
	
	public Version(double version_id, String encoding) {
		this.version_id = version_id;
		this.encoding = encoding;
	}
	
	public double getVersion_id() {
		return version_id;
	}
	
	public void setVersion_id(double version_id) {
		this.version_id = version_id;
	}
	
	public String getEncoding() {
		return encoding;
	}
	
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	@Override
	public String toString() {
		return "#VRML V" + version_id + " " + encoding;
	}
}
