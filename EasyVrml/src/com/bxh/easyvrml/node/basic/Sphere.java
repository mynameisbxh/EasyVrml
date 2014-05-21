package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Geometry;

public class Sphere implements Geometry {

	private double radius;		//球体半径
	
	protected final Map<String,Integer> required;		//必填属性

	protected final Map<String,Integer> exsisted;		//已存在属性
	
	public Sphere(){
		this(1.0);
	}
	
	public Sphere(double radius){
		this.radius = radius;
		
		required = new HashMap<>();
		required.put("radius", 0);
		
		exsisted = new HashMap<>();
		exsisted.put("radius", 0);
	}
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
}
