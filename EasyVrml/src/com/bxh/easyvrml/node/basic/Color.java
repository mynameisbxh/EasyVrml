package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;

public class Color implements Node {
	
	private double color[][];		//三维点的颜色
	
	protected final Map<String,Integer> required;		//必填属性

	protected final Map<String,Integer> exsisted;		//已存在属性
	
	public Color(){
		this(new double[0][0]);
	}
	
	public Color(double [][]color){
		this.color = color;
		
		required = new HashMap<>();
		required.put("color", 0);
		
		exsisted = new HashMap<>();
		exsisted.put("color", 0);
	}

	public double[][] getColor() {
		return color;
	}

	public void setColor(double[][] color) {
		this.color = color;
	}
}
