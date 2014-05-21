package com.bxh.easyvrml.node.basic;

import com.bxh.easyvrml.impl.Node;

public class NavigationInfo implements Node {

	private double 		avatarSize[];			//avater 就相当于替身。这个域值指定替身在浏览场景时的一些移动参数
	
	private boolean 	   headlight;			//确定浏览器是否要将头灯(headlight)打开
	
	private double 			   speed;			//通过设定替身的移动速度确定了观察者在场景中移动的速度，单位是 m/s
	
	private String			    type;			//指定观察者使用的导航类型,类型是“WALK”、“ EXAMINE”、“FLY”和“NONE”
	
	private double	 visibilityLimit;			//设定替身是用户能够在场景中看到的最远距离
	
	
	public NavigationInfo() {
		this(new double[]{0.25,1.6,0.75},true,1.0,"FLY",0.0);
	}

	public NavigationInfo(double[] avatarSize, boolean headlight, double speed,
			String type, double visibilityLimit) {
		this.avatarSize = avatarSize;
		this.headlight = headlight;
		this.speed = speed;
		this.type = type;
		this.visibilityLimit = visibilityLimit;
	}
	
	public double[] getAvatarSize() {
		return avatarSize;
	}
	public void setAvatarSize(double[] avatarSize) {
		this.avatarSize = avatarSize;
	}
	public boolean isHeadlight() {
		return headlight;
	}
	public void setHeadlight(boolean headlight) {
		this.headlight = headlight;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getVisibilityLimit() {
		return visibilityLimit;
	}
	public void setVisibilityLimit(double visibilityLimit) {
		this.visibilityLimit = visibilityLimit;
	}
	
}
