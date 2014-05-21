package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.extend.EventOut;

public class TimeSensor implements Node {

	private Long 		cycleInterval;			//每个变化周期的长度，以秒为单位，取值大于 0

	private boolean 		  enabled;			//设定是否产生时间的相关作用
	
	private boolean 		     loop;			//表明时间传感器是无限循环，还是在一个周期后被终止
	
	private Long			startTime;			//开始产生事件的时间
	
	private Long			 stopTime;			//终止产生事件的时间。其值若小于等于起始时间，则被忽略

	
	public final EventOut	cycleTime;			//出事件，单值布尔型。表明时间传感器当前是否在运行。若在运行，则返回 TRUE；若处
												//于停止状态，则返回 FALSE 。
	
	public final EventOut 	 isActive;			//出事件，单值时间型。在每个周期开始时，返回当前时间
	
	public final EventOut fraction_changed;
	
	public final EventOut		 Time;			//出事件，单值时间型。从格林威治时间 1970 年 1 月 1 日子时（午夜 12 点）至今所经过的秒数。
	
	protected Map<String,Integer> required;		//必填属性

	protected Map<String,Integer> exsisted;		//已存在属性
	
	public TimeSensor(Long cycleInterval) {
		this(cycleInterval,true,true,null,null);
	}
	
	public TimeSensor() {
		this(1L,true,true,null,null);
	}

	public TimeSensor(Long cycleInterval, boolean enabled, boolean loop,Long startTime, Long stopTime) {
		this.cycleInterval = cycleInterval;
		this.enabled = enabled;
		this.loop = loop;
		this.startTime = startTime;
		this.stopTime = stopTime;
		
		required = new HashMap<>();

		exsisted = new HashMap<>();
		exsisted.put("cycleInterval", 1);
		exsisted.put("enabled", 1);
		exsisted.put("loop", 1);
		exsisted.put("startTime", 1);
		exsisted.put("stopTime", 1);
		
		this.cycleTime = new EventOut("cycleTime","SFBool");
		this.isActive  = new EventOut("isActive","SFTime");
		this.fraction_changed = new EventOut("fraction_changed", "SFFloat");
		this.Time = new EventOut("Time","SFTime");
	}

	public Long getCycleInterval() {
		return cycleInterval;
	}

	public void setCycleInterval(Long cycleInterval) {
		this.cycleInterval = cycleInterval;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isLoop() {
		return loop;
	}

	public void setLoop(boolean loop) {
		this.loop = loop;
	}

	public Long getStartTime() {
		return startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	public Long getStopTime() {
		return stopTime;
	}

	public void setStopTime(Long stopTime) {
		this.stopTime = stopTime;
	}

	public EventOut getCycleTime() {
		return cycleTime;
	}

	public EventOut getIsActive() {
		return isActive;
	}

	public EventOut getFraction_changed() {
		return fraction_changed;
	}

	public EventOut getTime() {
		return Time;
	}
}
