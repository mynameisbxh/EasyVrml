package com.bxh.easyvrml.generator;

import java.math.BigDecimal;
import java.util.Random;

import com.bxh.easyvrml.element.field.Point3D;
import com.bxh.easyvrml.node.basic.Color;
import com.bxh.easyvrml.node.basic.ColorInterpolator;
import com.bxh.easyvrml.node.basic.Coordinate;
import com.bxh.easyvrml.tools.ColorConfig;
import com.bxh.easyvrml.tools.MathUtils;
/**
 * 用于生成颜色插值动画
 * 
 * @author BXH
 */
public class ColorInterpolatorGenerator {
	
	public static ColorInterpolator getColorInterpolatorByKeyValues(int count,double keyValue[][]){
		double key[] = new double[count + 1];
		for(int i = 0;i<count;i++){
			key[i] = i * (1.0/count);
		}
		key[count] = 1;
	    return new ColorInterpolator(key, keyValue);
	}
}
