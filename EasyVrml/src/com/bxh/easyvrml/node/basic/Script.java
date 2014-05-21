package com.bxh.easyvrml.node.basic;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.extend.EventIn;
import com.bxh.easyvrml.node.extend.EventOut;
import com.bxh.easyvrml.node.extend.Field;

public class Script implements Node {
	private  String         url;				//脚本的路径或者或脚本程序代码。如果是脚本文件，则列出的是文件路径，允许有多个路
												//径，浏览器执行第一个它能够理解执行的脚本。如果是脚本文件代码，则第一行列出的就是所
												//使用程序名称，通常是 Java、JavaScript 或者 VRMLScript 
	
	private  boolean mustEvaluate;				//每当新的值被 Script 节点的入事件 eventIn 接收时，该域值设置如何处理脚本程序
	
	private  boolean directOutput;				//这个域值设置是否允许 Script 节点的脚本直接改变场景节点和动态地建立或删除路由通
												//路
	
	private  String 	eventIn;   			//用来定义 Script 节点中的 eventIn 事件，指定该事件的事件类型和事件名称
	
	private  String 	  field;    			//用来定义 Script 节点中的 eventOut 事件，指定该事件的事件类型和事件名称
	
	private  String    eventOut;         		//用来定义 Script 节点中的域，指定该域的域值类型和域名称并且设置默认的域值
	
	protected Map<String,Integer> required;		//必填属性

	protected Map<String,Integer> exsisted;		//已存在属性
	
	public Script(String url,EventIn in,EventOut out){
		this("VRMLScript",url,false,false,in.getType() + " " + in.getEventIn(),"",out.getEventOut() + " " +out.getEventOut());
	}
	
	public Script(String url,EventIn in,EventOut out,Field field){
		this("VRMLScript",url,false,false,in.getType() + " " + in.getEventIn(),field.getFieldInfo(),out.getType() + " " +out.getEventOut());
	}
	
	public Script(String script,String url, boolean mustEvaluate, boolean directOutput,
			String eventIn, String field, String eventOut) {
		try {
			this.url = script +":\n\t"+ FileUtils.readFileToString(new File(url));
			this.mustEvaluate = mustEvaluate;
			this.directOutput = directOutput;
			this.eventIn = eventIn;
			this.field = field;
			this.eventOut = eventOut;
			
			required = new HashMap<>();
			required.put("url", 0);
			required.put("eventIn", 0);
			required.put("eventOut", 0);
			
			exsisted = new HashMap<>();
			exsisted.put("url", 1);
			exsisted.put("eventIn", 0);
			exsisted.put("eventOut", 0);
			exsisted.put("mustEvaluate", 1);
			exsisted.put("directOutput", 1);
			exsisted.put("field", 1);
		} catch (IOException e) {
			System.out.println(url+"---");
			e.printStackTrace();
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isMustEvaluate() {
		return mustEvaluate;
	}

	public void setMustEvaluate(boolean mustEvaluate) {
		this.mustEvaluate = mustEvaluate;
	}

	public boolean isDirectOutput() {
		return directOutput;
	}

	public void setDirectOutput(boolean directOutput) {
		this.directOutput = directOutput;
	}

	public String getEventIn() {
		return eventIn;
	}

	public void setEventIn(String eventIn) {
		this.eventIn = eventIn;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getEventOut() {
		return eventOut;
	}

	public void setEventOut(String eventOut) {
		this.eventOut = eventOut;
	}
	
	
}
