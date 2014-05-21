package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.exception.FieldLengthException;
import com.bxh.easyvrml.impl.Interpolator;
import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.extend.EventIn;
import com.bxh.easyvrml.node.extend.EventOut;
/**
 * 颜色插补器和时间传感器结合使用，描述颜色随时间的变化，从而使得造型的颜色呈现一
 * 种灵活、生动的变化效果
 *
 * @author BXH
 */
public class ColorInterpolator implements Interpolator {
    private double[] 		 key;      		//关键帧对应时间的列表，它表示的是每个关键帧对应的时间所占总动画时间的比率（即介
 										//于 0.0 和 1.0 之间的浮点数，包括 0.0 和 1.0）

    private double[][]	keyValue; 			//RGB 颜色值列表，分别对应于将在其中插值的各个关键帧的颜色值，从而随时间不断变化
 										//造型的颜色

    protected Map<String,Integer> required;		//必填属性

	protected Map<String,Integer> exsisted;		//已存在属性
	
    public final EventIn set_fraction;		//入事件，单值浮点型。已完成动画的时间比例。
 
    public final EventOut value_changed;		//出事件，单值浮点型。动画中给定点相应的颜色值。
	 
	public ColorInterpolator() {
		this(new double[]{0.00,0.25,0.50,0.75,1.00},
			 new double[][]{{1.0,0.0,0.0},{0.0,1.0,0.0},{0.0,0.0,1.0},{1.0,1.0,0.0},{1.0,0.0,1.0}});
	}

	public ColorInterpolator(double[] key, double[][] keyValue) {
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
