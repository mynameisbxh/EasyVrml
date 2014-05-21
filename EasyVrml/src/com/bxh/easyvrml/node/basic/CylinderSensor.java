package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.extend.EventOut;

public class CylinderSensor implements Node {
	 private double 	minAngle;		//拖动对象旋转所允许的最小角度。
	 
	 private double		maxAngle;		//拖动对象旋转所允许的最小角度。此域值同 minAngle 域值可以通过事件输入接口重新
	 									//设置。
	
	 private boolean	  enable;		//指定检测器是否有效。TRUE 表明检测器打开，FALSE 表明检测器关闭
	 
	 private double	   diskAngle;		//决定被检测对象的旋转行为是像一个圆柱还是像圆盘绕 Y 轴旋转
	 
	 private double		   offse;		//设置当每次拖动鼠标时对象转过的角度值。
	 
	 private boolean  autoOffset;		//确定用户每次拖动对象旋转的角度，并且对象停在新方位
	 
	 
	 protected Map<String, Integer> required; 		// 必填属性

	 protected Map<String,Integer> exsisted;		//已存在属性
	 
	public final EventOut isActive; 				// 出事件，单值布尔型。确定用户是否正在拖动被检测的对象，如是，输出 TRUE 事件。 

	public final EventOut trackPoint_changed; 		// 出事件，单值 3 维向量型。拖动鼠标的过程中，输出鼠标指针在包迹圆柱体表面的位置。

	public final EventOut rotation_changed ;		//出事件，单值旋转型。拖动鼠标的过程中，输出鼠标指针在包迹圆柱体表面的方位
		
	public CylinderSensor() {
		this(0,-1,true,0.262,0,true);
	}
	
	public CylinderSensor(double minAngle, double maxAngle, boolean enable,
			double diskAngle, double offse, boolean autoOffset) {
		this.minAngle = minAngle;
		this.maxAngle = maxAngle;
		this.enable = enable;
		this.diskAngle = diskAngle;
		this.offse = offse;
		this.autoOffset = autoOffset;
		
		required = new HashMap<>();
		
		exsisted = new HashMap<>();
		exsisted.put("minAngle", 1);
		exsisted.put("maxAngle", 1);
		exsisted.put("enabled", 1);
		exsisted.put("diskAngle", 1);
		exsisted.put("offse", 1);
		exsisted.put("autoOffset", 1);
		
		isActive = new EventOut("isActive","SFBool");
		trackPoint_changed = new EventOut("trackPoint_changed","SFVec3f");
		rotation_changed = new EventOut("rotation_changed","SFRotation");
	}
	
	public double getMinAngle() {
		return minAngle;
	}
	public void setMinAngle(double minAngle) {
		this.minAngle = minAngle;
	}
	public double getMaxAngle() {
		return maxAngle;
	}
	public void setMaxAngle(double maxAngle) {
		this.maxAngle = maxAngle;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public double getDiskAngle() {
		return diskAngle;
	}
	public void setDiskAngle(double diskAngle) {
		this.diskAngle = diskAngle;
	}
	public double getOffse() {
		return offse;
	}
	public void setOffse(double offse) {
		this.offse = offse;
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
