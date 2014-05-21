package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.exception.FieldLengthException;
import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.extend.EventIn;
import com.bxh.easyvrml.node.extend.EventOut;

public class ScalarInterpolator implements Node {
	private double[]		 key;   		//关键帧对应的时间比率列表。通常介于 0.0 和 1.0 之间的浮点数，包括 0.0 和 1.0
	
	private double[][]	keyValue;  			//内插坐标值列表，逐一对应于上面的时间比率列表中的数值。
	
	protected Map<String, Integer> required; // 必填属性

	protected Map<String, Integer> exsisted; // 已存在属性

	public final EventIn set_fraction; // 入事件，单值浮点型。已完成动画的时间比例。

	public final EventOut value_changed; // 出事件，单值浮点型。动画中给定点相应的颜色值。
	
	public ScalarInterpolator(double[] key, double[][] keyValue) {
		if(key.length!=keyValue.length){
			throw new FieldLengthException("key 和  keyValue的长度应该相同!");
		}else{
			this.key = key;
			this.keyValue = keyValue;
			required = new HashMap<>();
			required.put("key", 0);
			required.put("keyValue", 0);
			
			exsisted = new HashMap<>();
			exsisted.put("key", 0);
			exsisted.put("keyValue", 0);
			
			this.set_fraction = new EventIn("set_fraction", "SFFloat");
			this.value_changed = new EventOut("value_changed","SFColor");
		}
	}
	public double[] getKey() {
		return key;
	}
	public void setKey(double[] key) {
		this.key = key;
	}
	public double[][] getKeyValue() {
		return keyValue;
	}
	public void setKeyValue(double[][] keyValue) {
		this.keyValue = keyValue;
	}
	public EventIn getSet_fraction() {
		return set_fraction;
	}
	public EventOut getValue_changed() {
		return value_changed;
	}
}
