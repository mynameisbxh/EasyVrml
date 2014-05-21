package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.element.field.Point3D;
import com.bxh.easyvrml.impl.Light;
import com.bxh.easyvrml.impl.Node;

public class PointLight implements Light {
	private boolean 	  		 on;		//设置光源的打开和关闭。
	
	private double 		  intensity; 		//设置光源强度，在场景中就是设置了光源的亮度
	
	private double ambientIntensity; 		//设置光源对于场景中造型周围的环境光的影响程度，0 表示不受影响，而 1 表示完全受
											//影响。
	
	private double			[]color;		//设置光源的颜色，为能够实现预想的光照效果，必须考虑造型的漫散射颜色
	
	private double[]	   location;		//局部坐标系中光源的位置，需要注意的是，光源受坐标变换的影响，同一父坐标系下的造
											//型会受到光源的影响，而光源不会影响另外的坐标系中的造型
	
	private double			 radius;		//设置光源的作用半径，表明物体受到光源影响的最远距离
	
	private double[]	attenuation;		//设置光强衰减程度
	
	protected final Map<String,Integer> required;		//必填属性

	protected final Map<String,Integer> exsisted;		//已存在属性

	
	public PointLight() {
		this(true,10,1,new double[]{1.0,1.0,1.0},new double[]{0,0,0},100,new double[]{1,0,0});
	}
	
	public PointLight(boolean on,double []color,Point3D location) {
		this(true,10,1,color,new double[]{location.getX(),location.getY(),location.getZ()},100,new double[]{1,0,0});
	}

	public PointLight(boolean on, double intensity, double ambientIntensity,
			double []color, double[] location, double radius, double[] attenuation) {
		this.on = on;
		this.intensity = intensity;
		this.ambientIntensity = ambientIntensity;
		this.color = color;
		this.location = location;
		this.radius = radius;
		this.attenuation = attenuation;
		
		required = new HashMap<>();
		
		exsisted = new HashMap<>();
		exsisted.put("on", 1);
		exsisted.put("intensity", 1);
		exsisted.put("ambientIntensity", 1);
		exsisted.put("color", 1);
		exsisted.put("location", 1);
		exsisted.put("radius", 2);
		exsisted.put("attenuation", 1);
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

	public double[] getLocation() {
		return location;
	}

	public void setLocation(double[] location) {
		this.location = location;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double[] getAttenuation() {
		return attenuation;
	}

	public void setAttenuation(double[] attenuation) {
		this.attenuation = attenuation;
	}
}
