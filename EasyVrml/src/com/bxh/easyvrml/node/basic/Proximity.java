package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.extend.EventOut;

public class Proximity implements Node {
	private double[]		center;			//检测区域的中心，在该区域内传感器检测用户动作
	
	private double[]		  size;			//以 center 为中心，设定检测区沿每个坐标轴方向的坐标值，从而确定检测区域的大小
	
	private boolean 	   enabled;			//确定检测器是否打开。如果为 TRUE，表示检测器正在检测用户的动作

	protected Map<String, Integer> required; // 必填属性

	protected Map<String, Integer> exsisted; // 已存在属性
		
	public final EventOut isActive;				//输出事件，单值布尔型。TRUE 表示用户是否进入检测区域，FALSE 表示离开该区域。
		
	public final EventOut position_changed;				//输出事件，3 维向量型。浏览者当前的位置，随着浏览者进入或在检测区域里的移动而随
												//时修改。
	
	public final EventOut orientation_changed;				//输出事件，单值旋转型。浏览者当前的方位，随着浏览者进入或在检测区域里的移动而随
												//时修改
	
	public final EventOut enterTime;
	
	public final EventOut exitTime;
	
	
	public Proximity() {
		this(new double[]{0.0,0.0,0.0},new double[]{0.0,0.0,0.0},true);
	}

	public Proximity(double[] center, double[] size, boolean enabled) {
		super();
		this.center = center;
		this.size = size;
		this.enabled = enabled;
		
		required = new HashMap<>();
		
		exsisted = new HashMap<>();
		exsisted.put("center", 1);
		exsisted.put("size", 1);
		exsisted.put("enabled", 1);
		
		isActive = new EventOut("isActive","SFBool");
		position_changed = new EventOut("position_changed","SFVec3f");
		orientation_changed = new EventOut("orientation_changed","SFRotation");
		enterTime = new EventOut("enterTime","SFTime");
		exitTime = new EventOut("exitTime","SFTime");
	}

	public double[] getCenter() {
		return center;
	}

	public void setCenter(double[] center) {
		this.center = center;
	}

	public double[] getSize() {
		return size;
	}

	public void setSize(double[] size) {
		this.size = size;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public EventOut getIsActive() {
		return isActive;
	}

	public EventOut getPosition_changed() {
		return position_changed;
	}

	public EventOut getOrientation_changed() {
		return orientation_changed;
	}

	public EventOut getEnterTime() {
		return enterTime;
	}

	public EventOut getExitTime() {
		return exitTime;
	}

}
