package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.extend.EventOut;

public class SphereSensor implements Node {
	private boolean 	enabled;		//确定检测器是否打开。TRUE 表示检测器是打开的。
	
	private double[]	 offset;		//定义每次拖动对象其相对于初始位置的旋转角度
	
	private boolean	 autoOffset;		//相当于自动设置 off set。如果值为 TRUE，表示在拖动结束时，将当前的方位值存储到 offset
										//中，并且对象停在该方位；若值为 FALSE ，在用户每次开始一个新的拖动时，几何体复位到初
										//始值。

	protected Map<String, Integer> required; // 必填属性

	protected Map<String, Integer> exsisted; // 已存在属性
	 
	public final EventOut isActive; 				// 出事件，单值布尔型。确定用户是否正在拖动被检测的对象，如是，输出 TRUE 事件。 

	public final EventOut trackPoint_changed; 		// 出事件，单值 3 维向量型。拖动鼠标的过程中，输出鼠标指针在包迹圆柱体表面的位置。

	public final EventOut rotation_changed ;		//出事件，单值旋转型。拖动鼠标的过程中，输出鼠标指针在包迹圆柱体表面的方位
	
	public SphereSensor() {
		this(true,new double[]{0.0,1.0,0.0,0.0},true);
	}
	
	public SphereSensor(boolean enabled,double[] offset,boolean autoOffset) {
		this.enabled = enabled;
		this.offset = offset;
		this.autoOffset = autoOffset;
		
		required = new HashMap<>();
		
		exsisted = new HashMap<>();
		exsisted.put("enabled", 1);
		exsisted.put("offset", 1);
		exsisted.put("autoOffset", 1);
		
		isActive = new EventOut("isActive","SFBool");
		trackPoint_changed = new EventOut("trackPoint_changed","SFVec3f");
		rotation_changed = new EventOut("rotation_changed","SFRotation");
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public double[] getOffset() {
		return offset;
	}

	public void setOffset(double[] offset) {
		this.offset = offset;
	}

	public boolean isAutoOffset() {
		return autoOffset;
	}

	public void setAutoOffset(boolean autoOffset) {
		this.autoOffset = autoOffset;
	}

	public EventOut getIsActive() {
		return isActive;
	}

	public EventOut getTrackPoint_changed() {
		return trackPoint_changed;
	}

	public EventOut getRotation_changed() {
		return rotation_changed;
	}
	
}
