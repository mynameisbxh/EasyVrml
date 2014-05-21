package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;

public class LOD implements Node {
	private double[]	range;			//给定一系列的从观察者到要显示物体的距离，这些距离分别对应要显示的不同细节的层
										//次
	
	private double[]   center; 			//指定 LOD 节点的子节点的几何中心所在的位置，这个位置用来确定用户和造型之间的距离
	
	private Node[]		level;			//放置一组子节点，各子节点分别代表了不同细节层次的对应造型或场景，次序是从最高细
										//节层次到最低细节层次，这个域的值和 range 域的值密切相关，最祥细层次对应的是最短的距
										//离
	protected final Map<String,Integer> required;		//必填属性

	protected final Map<String,Integer> exsisted;		//已存在属性
	
	public LOD(Node[] level) {
		this(new double[]{15,20},new double[]{0,0,0},level);
	}
	
	public LOD(double[] range, double[] center, Node[] level) {
		this.range = range;
		this.center = center;
		this.level = level;
		
		required = new HashMap<>();
		required.put("level", 0);
		
		exsisted = new HashMap<>();
		exsisted.put("level", 0);
		exsisted.put("center", 1);
		exsisted.put("range", 1);
	}

	public double[] getRange() {
		return range;
	}

	public void setRange(double[] range) {
		this.range = range;
	}

	public double[] getCenter() {
		return center;
	}

	public void setCenter(double[] center) {
		this.center = center;
	}

	public Node[] getLevel() {
		return level;
	}

	public void setLevel(Node[] level) {
		this.level = level;
	}
	
}
