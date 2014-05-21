package com.bxh.easyvrml.element.field;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;

public class Point3D implements Node{

	private double x;
	private double y;
	private double z;
	
	protected final Map<String,Integer> required;		//必填属性

	protected final Map<String,Integer> exsisted;		//已存在属性
	
	public Point3D() {
		this(0,0,0);
	}
	
	public Point3D(double x, double y ,double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		
		required = new HashMap<>();
		required.put("x", 0);
		required.put("y", 0);
		required.put("z", 0);
		
		exsisted = new HashMap<>();
		exsisted.put("x", 0);
		exsisted.put("y", 0);
		exsisted.put("z", 0);
	}

	public double getX() {
		return x;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}

	public void setZ(double z) {
		this.z = z;
	}
	
	public double getZ() {
		return z;
	}
	
}
