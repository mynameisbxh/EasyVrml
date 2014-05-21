package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;

public class DirectionalLight implements Node {
	private boolean		   		 on;			//  TRUE  # expected field SFBool
	
	private double 		  intensity; 			// 1  # expected field SFFloat
	
	private double ambientIntensity;  			//0  # expected field SFFloat  
	
	private double			[]color;  			//1 1 1  # expected field SFColor
	
	private double		  []direction;			//  0 0 – 1  # expected field SFVec3f 

	protected final Map<String,Integer> required;		//必填属性

	protected final Map<String,Integer> exsisted;		//已存在属性
	
	public DirectionalLight(double []color,double []direction) {
		this(true,1,0,color,direction);
	}

	public DirectionalLight(boolean on, double intensity,double ambientIntensity, double []color, double []direction) {
		this.on = on;
		this.intensity = intensity;
		this.ambientIntensity = ambientIntensity;
		this.color = color;
		this.direction = direction;
		
		required = new HashMap<>();
		
		exsisted = new HashMap<>();
		exsisted.put("on", 1);
		exsisted.put("intensity", 1);
		exsisted.put("ambientIntensity", 1);
		exsisted.put("color", 1);
		exsisted.put("direction", 1);
	}

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}

	public double getIntensity() {
		return intensity;
	}

	public void setIntensity(double intensity) {
		this.intensity = intensity;
	}

	public double getAmbientIntensity() {
		return ambientIntensity;
	}

	public void setAmbientIntensity(double ambientIntensity) {
		this.ambientIntensity = ambientIntensity;
	}

	public double[] getColor() {
		return color;
	}

	public void setColor(double []color) {
		this.color = color;
	}

	public double[] getDirection() {
		return direction;
	}

	public void setDirection(double []direction) {
		this.direction = direction;
	}
}
