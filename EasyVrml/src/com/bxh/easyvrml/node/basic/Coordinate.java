package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;

public class Coordinate implements Node {
	
	private double point[][];		//三维坐标集
	
	protected final Map<String,Integer> required;		//必填属性

	protected final Map<String,Integer> exsisted;		//已存在属性
	
	public Coordinate(){
		this(new double[0][0]);
	}
	
	public Coordinate(double [][]point){
		this.point = point;
		required = new HashMap<>();
		required.put("point", 0);
		
		exsisted = new HashMap<>();
		exsisted.put("point", 0);
	}

	public double[][] getPoint() {
		return point;
	}

	public void setPoint(double[][] point) {
		this.point = point;
	}
	
}
