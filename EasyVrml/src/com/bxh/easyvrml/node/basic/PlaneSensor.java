package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.extend.EventOut;

public class PlaneSensor implements Node {
	private double[]	minPosition;		//把对象的移动限制在某一点的上方和右方。默认值为 x=0,y=0
	
	private double[]	maxPosition;		//把对象的移动限制在某一点的下方和左方。默认值为 x=-1,y=-1。
	
	private boolean		    enabled;		//指示传感器当前是否响应鼠标事件
	
	private double[]		 offset;		//定义出对象被移动后相对于初始点的最远位置。
	
	private boolean		 autoOffset;		//决定每次鼠标拖动后再次拖动对象时开始的位置
	
	protected Map<String, Integer> required; // 必填属性

	protected Map<String,Integer> exsisted;		//已存在属性
	

	public final EventOut 	isActive;	//输出事件，单域值布尔型。表示鼠标键是否被按下。此事件仅当按钮被按下或释放时才发
										//出，而拖动时则不会发生。
	
	public final EventOut 	trackPoint_changed;		//输出事件，单域值 3 维向量型。记录拖动对象后鼠标在 X-Y 平面上的确定位置。这里可以
													//忽略域值 minPosition 和maxPosition 的限制。
	
	public final EventOut 	translation_changed ;	//输出事件，单域值 3 维向量型。记录拖动对象过程中鼠标在 X-Y 平面上的暂时位置。这个
													//时间要受域值 minPosition 和 maxPosition 的限制
	
	
	public PlaneSensor() {
		this(new double[]{0.0,0.0},new double[]{-1,-1},true,new double[]{0.0,0.0,0.0},true);
	}
	
	public PlaneSensor(double[] minPosition, double[] maxPosition,
			boolean enabled, double[] offset, boolean autoOffset) {
		this.minPosition = minPosition;
		this.maxPosition = maxPosition;
		this.enabled = enabled;
		this.offset = offset;
		this.autoOffset = autoOffset;
		
		required = new HashMap<>();
		
		exsisted = new HashMap<>();
		exsisted.put("minPosition", 1);
		exsisted.put("maxPosition", 1);
		exsisted.put("enabled", 1);
		exsisted.put("offset", 1);
		exsisted.put("autoOffset", 1);
		
		isActive = new EventOut("isActive","SFBool");
		trackPoint_changed = new EventOut("trackPoint_changed","SFVec3f");
		translation_changed = new EventOut("translation_changed","SFVec3f");
	}
	public double[] getMinPosition() {
		return minPosition;
	}
	public void setMinPosition(double[] minPosition) {
		this.minPosition = minPosition;
	}
	public double[] getMaxPosition() {
		return maxPosition;
	}
	public void setMaxPosition(double[] maxPosition) {
		this.maxPosition = maxPosition;
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

	public EventOut getTranslation_changed() {
		return translation_changed;
	}
}
