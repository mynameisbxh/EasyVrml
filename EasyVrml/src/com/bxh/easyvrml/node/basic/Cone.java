package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Geometry;

public class Cone implements Geometry {

	private double height;				//圆锥高度
	private double bottomRadius;		//底面半径
	private boolean bottom;				//是否显示底面
	private boolean side;				//是否显示侧面
	
	protected final Map<String,Integer> required;		//必填属性

	protected final Map<String,Integer> exsisted;		//已存在属性
	
	public Cone(){
		this(1.0,0.5);
	}
	
	public Cone(double height,double bottomRadius){
		this(height,bottomRadius,true,true);
	}
	
	public Cone(double height,double bottomRadius,boolean bottom,boolean side){
		this.height = height;
		this.bottomRadius = bottomRadius;
		this.bottom = bottom;
		this.side = side;
		
		required = new HashMap<>();
		required.put("height", 0);
		required.put("bottomRadius", 0);

		exsisted = new HashMap<>();
		exsisted.put("height", 0);
		exsisted.put("bottomRadius", 0);
		exsisted.put("bottom", 1);
		exsisted.put("side", 1);
	}
	
	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getBottomRadius() {
		return bottomRadius;
	}

	public void setBottomRadius(double bottomRadius) {
		this.bottomRadius = bottomRadius;
	}

	public boolean isBottom() {
		return bottom;
	}

	public void setBottom(boolean bottom) {
		this.bottom = bottom;
	}

	public boolean isSide() {
		return side;
	}

	public void setSide(boolean side) {
		this.side = side;
	}
	
}
