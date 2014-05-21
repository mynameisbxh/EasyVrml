package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.extend.EventIn;
import com.bxh.easyvrml.node.extend.EventOut;

public class Fog implements Node {

    private String 		 fogType;		//随着观察者距离的增加，雾的浓度发生变化，其值可以取"LINEAR" ，"EXPONENTAL" ，
    									//亦即是线形变化还是指数变化。实际上该域确定雾增加的速率
    
    private double visibilityRange;    	//观察者能在雾中看到所有造型的最大距离。0 或小于 0 的值表示没有雾
    
    private double		   []color;	    //雾的颜色
    
    protected final Map<String,Integer> required;		//必填属性

	protected final Map<String,Integer> exsisted;		//已存在属性
	
	public final EventIn set_bind;		//入事件，单值布尔型。通过外部事件的驱动，使 Fog 节点变成当前在使用的节点。
	
	public final EventOut isBound;		//出事件，单值布尔型。决定目前 Fog 节点是否被激活。如被激活则输出 TRUE
	  
	public Fog() {
		this("LINEAR",10,new double[]{1.0,1.0,1.0});
	}

	public Fog(String fogType, double visibilityRange, double []color) {
		this.fogType = fogType;
		this.visibilityRange = visibilityRange;
		this.color = color;
		
		required = new HashMap<>();
		
		exsisted = new HashMap<>();
		exsisted.put("fogType", 1);
		exsisted.put("visibilityRange", 1);
		exsisted.put("color", 1);
		
		this.set_bind = new EventIn("set_bind","SFBool");
		this.isBound = new EventOut("isBound","SFBool");
	}
	
	public String getFogType() {
		return fogType;
	}
	public void setFogType(String fogType) {
		this.fogType = fogType;
	}
	public double getVisibilityRange() {
		return visibilityRange;
	}
	public void setVisibilityRange(double visibilityRange) {
		this.visibilityRange = visibilityRange;
	}
	public double[] getColor() {
		return color;
	}
	public void setColor(double []color) {
		this.color = color;
	}
	  
}
