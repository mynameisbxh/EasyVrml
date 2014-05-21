package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.extend.EventIn;
import com.bxh.easyvrml.node.extend.EventOut;
import com.bxh.easyvrml.tools.VrmlUtils;

/**
 * ViewPoint 用于表示一个空间视点
 * 
 * @author BXH
 */
public class Viewpoint implements Node {

	private double position[];				//视点的空间坐标
	
	private double orientation[];			//视点的空间朝向
	
	private double fieldOfView;				//设定观察者观察场景所张的视角的大小(视角域大于 0，小于 pi,缺省值相当于 45°)
	
	private String description;				//视点描述
	
	private boolean jump;					//浏览者在视点之间切换时，视点位置变化的方式.若为 TRUE 的话，将立刻跳到新位置，不经过前后两个位置之间的任
											//何空间，表现为一种跳跃的方式。如果设置为 FALSE ，则浏览器在视点变化过程中会采取逐渐
											//过渡的方式，尽可能使得视点的切换连续，使得观察到的视点切换平滑，称为非跳跃视点变化
											//的方式。
	
	protected Map<String,Integer> required;		//必填属性

	protected Map<String,Integer> exsisted;		//已存在属性
	
	public final EventIn	set_bind;					//若接收一个值为 TRUE 的事件将 Viewpoint 节点激活，使之成为场
												//景当前的 Viewpoint 节点
	
	public final EventOut	bindTime;					//视点被激活的时间。该输出事件用来在一个给定视点被激活时开始
												//运行一个动画或脚本
	
	public Viewpoint(){
		this(new double[]{0.0,2.0,20.0},new double[]{1.0,0.0,0.0,VrmlUtils.getDegree(10)},VrmlUtils.getDegree(45),"default",false);
	}
	
	public Viewpoint(double position[],double orientation[],double fieldOfView,String description,boolean jump){
		this.position = position;
		this.orientation = orientation;
		this.fieldOfView = fieldOfView;
		this.description = description;
		this.jump = jump;
		
		required = new HashMap<>();
		
		exsisted = new HashMap<>();
		exsisted.put("position", 1);
		exsisted.put("orientation", 1);
		exsisted.put("fieldOfView", 1);
		exsisted.put("description", 1);
		exsisted.put("jump", 1);
		
		set_bind = new EventIn("set_bind","SFBool");
		bindTime = new EventOut("bindTime","SFTime");
	}
	

	public double[] getPosition() {
		return position;
	}

	public void setPosition(double[] position) {
		this.position = position;
	}

	public double[] getOrientation() {
		return orientation;
	}

	public void setOrientation(double[] orientation) {
		this.orientation = orientation;
	}

	public double getFieldOfView() {
		return fieldOfView;
	}

	public void setFieldOfView(double fieldOfView) {
		this.fieldOfView = fieldOfView;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isJump() {
		return jump;
	}

	public void setJump(boolean jump) {
		this.jump = jump;
	}

	public EventIn getSet_bind() {
		return set_bind;
	}

	public EventOut getBindTime() {
		return bindTime;
	}
}
