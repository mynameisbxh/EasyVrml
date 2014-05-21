package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;

public class Inline implements Node {

	private String         url;			//指定一个或者多个 VRML 文件的路径，该路径可以是本地磁盘文件路径，也可以是网络中
											//的 VRML 文件
	
	private double[]  bboxCenter;		    //包围该组节点的所有子节点的区域的中心
	
	private double[]    bboxSize;			//包围该组节点的所有子节点的区域在 X、Y、Z 方向上的大小，缺省值指明没有包围区域，
											//由浏览器自己计算合适的区域

	protected final Map<String,Integer> required;		//必填属性

	protected final Map<String,Integer> exsisted;		//已存在属性
	
	
	public Inline(String url) {
		this(url,new double[]{0.0,0.0,0.0},new double[]{-1,-1,-1});
	}

	public Inline(String url, double[] bboxCenter, double[] bboxSize) {
		this.url = url;
		this.bboxCenter = bboxCenter;
		this.bboxSize = bboxSize;
		
		required = new HashMap<>();
		required.put("url", 0);
		
		exsisted = new HashMap<>();
		exsisted.put("url", 1);
		exsisted.put("bboxCenter", 2);
		exsisted.put("bboxSize", 2);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public double[] getBboxCenter() {
		return bboxCenter;
	}

	public void setBboxCenter(double[] bboxCenter) {
		this.bboxCenter = bboxCenter;
	}

	public double[] getBboxSize() {
		return bboxSize;
	}

	public void setBboxSize(double[] bboxSize) {
		this.bboxSize = bboxSize;
	}
}
