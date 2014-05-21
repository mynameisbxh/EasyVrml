package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.tools.VrmlUtils;

public class SpotLight implements Node {
	private boolean				 on;			//设置光源打开还是关闭，如果设置为 FALSE 关闭光源，则对场景中没有光照作用
	
	private double	 	  intensity;			//设置光源的强度，也就是光源的亮度
	
	private double ambientIntensity; 			//设置光源对于场景中造型周围的环境光的影响程度，0 表示不受影响，而 1 表示完全受
												//影响
	
	private double			[]color;			//设置光源的颜色，为能够实现预想的光照效果，必须考虑造型的漫散射颜色。
	
	private double[]	   location;			//设置光源所在的位置坐标，即圆锥的顶点。
	
	private double[]	  direction;			//设置光线形成的圆锥的轴线的方向
	
	private double		  beamWidth;			//设置光线散射的角度（以弧度为单位） 。在这个散射角内，光的强度一致。出了散射角光
												//强逐渐减弱，在光源的遮挡角的锥面处降为零
	
	private double		cutOffAngle;			//设置光源的遮挡角，既光线圆锥面的锥角，只有位于该散射角范围内的虚拟对象才能够被
												//照射到
	
	private double			 radius;			//设置光源的最大射程
	
	private double[]	attenuation;			//设置光源强度的衰减程度
	
	protected final Map<String,Integer> required;		//必填属性

	protected final Map<String,Integer> exsisted;		//已存在属性
	
	public SpotLight() {
		this(true,1,1,new double[]{1,0,0},new double[]{0,0,0},new double[]{1,0,0},VrmlUtils.getDegree(10),VrmlUtils.getDegree(45),100,new double[]{1,0,0});
	}
	
	public SpotLight(boolean on,double []location,double []color,double []direction) {
		this(on,1,1,color,location,direction,1.570796,0.785398,100,new double[]{1,0,0});
	}

	public SpotLight(boolean on, double intensity, double ambientIntensity,double []color, double[] location, double[] direction,
			double beamWidth, double cutOffAngle, double radius,double[] attenuation) {
		this.on = on;
		this.intensity = intensity;
		this.ambientIntensity = ambientIntensity;
		this.color = color;
		this.location = location;
		this.direction = direction;
		this.beamWidth = beamWidth;
		this.cutOffAngle = cutOffAngle;
		this.radius = radius;
		this.attenuation = attenuation;
		
		required = new HashMap<>();
		
		exsisted = new HashMap<>();
		exsisted.put("on", 1);
		exsisted.put("intensity", 1);
		exsisted.put("ambientIntensity", 1);
		exsisted.put("color", 1);
		exsisted.put("location", 1);
		exsisted.put("direction", 1);
		exsisted.put("beamWidth", 1);
		exsisted.put("cutOffAngle", 1);
		exsisted.put("radius", 1);
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
	public double[] getDirection() {
		return direction;
	}
	public void setDirection(double[] direction) {
		this.direction = direction;
	}
	public double getBeamWidth() {
		return beamWidth;
	}
	public void setBeamWidth(double beamWidth) {
		this.beamWidth = beamWidth;
	}
	public double getCutOffAngle() {
		return cutOffAngle;
	}
	public void setCutOffAngle(double cutOffAngle) {
		this.cutOffAngle = cutOffAngle;
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
