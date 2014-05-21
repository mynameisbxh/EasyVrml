package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.extend.EventOut;

public class VisibilitySensor implements Node {
	private double[] 		center;    	//定义该传感器的可检测区域的几何中心
	
	private double[]		  size;		//定义该传感器的可检测区域在 X、Y、Z 方向的大小
	
	private boolean		   enabled;		//确定 VisibilitySensor 是否处于激活状态。
	
	protected Map<String, Integer> required; // 必填属性

	protected Map<String, Integer> exsisted; // 已存在属性
	
	public final EventOut isActive;				//输出事件，单值布尔型。TRUE 表明用户已进入可检测区域；FALSE 表明用户不在该区
												//域内。
	
	public final EventOut enterTime;			//输出事件，单值时间型。进入可见区域的时间。
	
	public final EventOut exitTime;				//输出事件，单值时间型。离开可见区域的时间
	
	public VisibilitySensor() {
		this(new double[]{0.0,0.0,0.0},new double[]{0.0,0.0,0.0},true);
	}

	public VisibilitySensor(double[] center, double[] size, boolean enabled) {
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
	
	
}
