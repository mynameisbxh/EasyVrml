package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Geometry;

public class Text implements Geometry {

	private String []string;		//文本内容
	private double []length;		//设置单个文本串的长度，0 表示可以为任意长度。这个域是多值的，值的个数取决于设置
									//的字符串的个数，每个依次对应 string 域的每个字符串的长度。
	
	private double maxExtent;		//确定文本的任意一行在主要方向上的最大范围。 其值必须大于等于 0。 主要方向由 FontStyle
									//节点的 hori zonal 域来确定，如果该域值是 TRUE，则主要方向是水平方向，否则是垂直方向。
									//MaxExtent 域值的默认值为 0，表示字符串可为任意长度。
	
	private FontStyle fontStyle;	//设置字符串的相关文本特性
	
	protected final Map<String,Integer> required;		//必填属性

	protected final Map<String,Integer> exsisted;		//已存在属性
	
	public Text(String []string){
		this(string,new double[string.length],0.0,new FontStyle());
	}
	
	public Text(String []string,double []length,double maxExtent,FontStyle fontStyle){
		this.string = string;
		this.length = length;
		this.maxExtent = maxExtent;
		this.fontStyle = fontStyle;
		
		required = new HashMap<>();
		required.put("string", 0);

		exsisted = new HashMap<>();
		exsisted.put("string", 0);
		exsisted.put("length", 1);
		exsisted.put("maxExtent", 1);
		exsisted.put("fontStyle", 1);
	}

	public String[] getString() {
		return string;
	}

	public void setString(String[] string) {
		this.string = string;
	}

	public double[] getLength() {
		return length;
	}

	public void setLength(double[] length) {
		this.length = length;
	}

	public double getMaxExtent() {
		return maxExtent;
	}

	public void setMaxExtent(double maxExtent) {
		this.maxExtent = maxExtent;
	}

	public FontStyle getFontStyle() {
		return fontStyle;
	}

	public void setFontStyle(FontStyle fontStyle) {
		this.fontStyle = fontStyle;
	}
	
}
