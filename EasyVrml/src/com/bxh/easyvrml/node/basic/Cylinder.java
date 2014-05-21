package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Geometry;
/**
 * Cylinder 圆柱体
 * 
 * @author BXH
 */
public class Cylinder implements Geometry {

	private double height;				//圆柱体高度
	private double radius;				//圆柱体底面半径
	private boolean side;				//是否显示圆柱侧面
	private boolean bottom;				//是否显示下底面
	private boolean top;				//是否显示上底面
	
	protected final Map<String,Integer> required;		//必填属性

	protected final Map<String,Integer> exsisted;		//已存在属性
	
	
	public Cylinder(){
		this(1.0,0.5);
	}
	
	public Cylinder(double height,double radius){
		this(height,radius,true,true,true);
	}
	
	public Cylinder(double height,double radius,boolean isShowSide,boolean isShowBottom,boolean isShowTop){
		this.height = height;
		this.radius = radius;
		this.bottom = isShowBottom;
		this.side = isShowSide;
		this.top = isShowTop;
		
		required = new HashMap<>();
		required.put("height", 0);
		required.put("radius", 0);
		
		exsisted = new HashMap<>();
		exsisted.put("height", 0);
		exsisted.put("radius", 0);
		exsisted.put("bottom", 1);
		exsisted.put("side", 1);
		exsisted.put("top", 1);
	}
	
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}

	public boolean isSide() {
		return side;
	}

	public void setSide(boolean side) {
		this.side = side;
	}

	public boolean isBottom() {
		return bottom;
	}

	public void setBottom(boolean bottom) {
		this.bottom = bottom;
	}

	public boolean isTop() {
		return top;
	}

	public void setTop(boolean top) {
		this.top = top;
	}
}
