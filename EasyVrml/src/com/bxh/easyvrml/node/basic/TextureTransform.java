package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;

public class TextureTransform implements Node {
	private double[] translation;		//确定纹理坐标系的平移
	
	private double 		rotation;		//指定一个以 center 域中定义的任意中心为原点的旋转，其值以弧度表示。旋转的是纹理坐
										//标系，不是纹理本身
	
	private double[]        scale;		//指定一个以 center 域中定义的任意中心为原点的缩放
	
	private double[]	   center;		//对于纹理，定义一个缩放和旋转的任意中心
	
	protected final Map<String,Integer> required;		//必填属性

	protected final Map<String,Integer> exsisted;		//已存在属性
	
	public TextureTransform() {
		this(new double[]{0,0},0,new double[]{1,1},new double[]{0,0});
	}

	public TextureTransform(double[] translation, double rotation,double[] scale, double[] center) {
		this.translation = translation;
		this.rotation = rotation;
		this.scale = scale;
		this.center = center;
		
		required = new HashMap<>();
		
		exsisted = new HashMap<>();
		exsisted.put("translation", 1);
		exsisted.put("rotation", 1);
		exsisted.put("scale", 1);
		exsisted.put("center", 1);
	}
	
	public double[] getTranslation() {
		return translation;
	}
	
	public void setTranslation(double[] translation) {
		this.translation = translation;
	}
	public double getRotation() {
		return rotation;
	}
	public void setRotation(double rotation) {
		this.rotation = rotation;
	}
	public double[] getScale() {
		return scale;
	}
	public void setRcale(double[] scale) {
		this.scale = scale;
	}
	public double[] getCenter() {
		return center;
	}
	public void setCenter(double[] center) {
		this.center = center;
	}
}
