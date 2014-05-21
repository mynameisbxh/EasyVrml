package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.extend.EventOut;

public class TouchSensor implements Node {

	private boolean		enabled;			//enabled 表明此传感器是否对用户输入设备做出反应

	protected Map<String, Integer> required; // 必填属性

	protected Map<String,Integer> exsisted;		//已存在属性
	
	public final EventOut 	isOver;					//出事件，单值布尔型。这个事件指出鼠标当前是否正指在对象上，只要鼠标位于对象上无
												//论是否有操作（按键、拖动等） ，就会输出 TRUE，否则输出 FALSE 
	
	public final EventOut 	isActive;				//出事件，单值布尔型。指明鼠标的按键是否被按下，鼠标键按下输出 TRUE ，否则输出
												//FALSE 。
	
	public final EventOut 	hitPoint_changed;		//出事件，单值 3 维向量型。当鼠标位于对象上时，单击鼠标左键则会输出事件。同上面情
												//况有所不同，这时输出的是位置坐标。
	
	public final EventOut 	hitNormal_changed;		//出事件，单值 3 维向量型。这个事件输出的是 hitPoint_changed 所指定点的法向量
	
	public final EventOut 	hitTexCoord_changed;	//出事件，单值 2 维坐标型。hitPoing_changed 所指定点的造型表面的纹理坐标。
	
	public final EventOut 	touchTime;				//出事件，单值时间型。输出单击鼠标的时间
	
	public TouchSensor() {
		this(true);
	}

	public TouchSensor(boolean enabled) {
		this.enabled = enabled;
		
		required = new HashMap<>();
		
		exsisted = new HashMap<>();
		exsisted.put("enabled", 1);
		
		touchTime = new EventOut("touchTime","SFTime");
		hitTexCoord_changed = new EventOut("hitTexCoord_changed","SFVec2f");
		hitNormal_changed = new EventOut("hitNormal_changed","SFVec3f");
		hitPoint_changed = new EventOut("hitPoint_changed","SFVec3f");
		isActive = new EventOut("isActive","SFBool");
		isOver = new EventOut("isOver","SFBool");
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public EventOut getIsOver() {
		return isOver;
	}

	public EventOut getIsActive() {
		return isActive;
	}

	public EventOut getHitPoint_changed() {
		return hitPoint_changed;
	}

	public EventOut getHitNormal_changed() {
		return hitNormal_changed;
	}

	public EventOut getHitTexCoord_changed() {
		return hitTexCoord_changed;
	}

	public EventOut getTouchTime() {
		return touchTime;
	}
}
