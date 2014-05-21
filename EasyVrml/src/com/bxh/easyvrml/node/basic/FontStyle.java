package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;

public class FontStyle implements Node {
	
	private double size;				//根据文本的排列方向，确定每行水平文字的高度，或每列垂直文字的宽度，默认值为 1.0
	
	private String family;				//指明文字是属于哪一类字体，可有三种选择：Serif 类字体、Sans 类字体或 Typewriter 类字
										//体
	
	private String style;				//用来指明文字是常规字体、粗体、斜体或粗斜体。空串表示常规字体。
	
	private boolean horizontal;			//表示文字的方向。选择 TRUE 表示水平文字方向，选择 FALSE 表示垂直文字方向。
	
	private boolean leftToRight;		//表示文字读取的方向。选择 TRUE 是从左向右读，选择 FALSE 表示从右向左读。
	
	private boolean topToBottom;		//类似于 leftToRight，但是用来表示垂直方向排列的文字的读取方向
	
	private String language;			//使用的语言
	
	private String[] justify;			//第一个串值表示文字是左对齐、居中对齐，还是右对齐。例如：对于从左向右的水平文字，
										//"BEGIN" 表示左对齐，"MIDDLK" 表示居中对齐，"END"   表示右对齐。第二个串值表示在次方
										//向上如何对齐文字块。如果第二个串值未设定则取缺省值"FIRST" 。
	private double spacing;				//表示行间距。1 表示单行间距，行间距离为 1 个 size 单位；2 表示双行间距，相当于其间
										//加了一个空行。
	
	protected final Map<String,Integer> required;		//必填属性

	protected final Map<String,Integer> exsisted;		//已存在属性
	
	public FontStyle(double size){
		this(size,"","",true,true,true,"en",new String[]{"BEGIN","FIRST"},1.0);
	}
	
	public FontStyle(){
		this(1.0,"","",true,true,true,"en",new String[]{"BEGIN","FIRST"},1.0);
	}
	
	public FontStyle(double size,String family,String style,boolean horizontal,boolean leftToRight,boolean topToBottom,String language,String []justify,double spacing){
		this.size = size;
		this.family = family;
		this.style = style;
		this.horizontal = horizontal;
		this.leftToRight = leftToRight;
		this.language = language;
		this.topToBottom = topToBottom;
		this.justify = justify;
		this.spacing = spacing;
		
		required = new HashMap<>();

		exsisted = new HashMap<>();
		exsisted.put("size", 1);
		exsisted.put("family", 1);
		exsisted.put("style", 1);
		exsisted.put("horizontal", 1);
		exsisted.put("leftToRight", 1);
		exsisted.put("language", 1);
		exsisted.put("topToBottom", 1);
		exsisted.put("justify", 1);
		exsisted.put("spacing", 1);
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public boolean isHorizontal() {
		return horizontal;
	}

	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	public boolean isLeftToRight() {
		return leftToRight;
	}

	public void setLeftToRight(boolean leftToRight) {
		this.leftToRight = leftToRight;
	}

	public boolean isTopToBottom() {
		return topToBottom;
	}

	public void setTopToBottom(boolean topToBottom) {
		this.topToBottom = topToBottom;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String[] getJustify() {
		return justify;
	}

	public void setJustify(String[] justify) {
		this.justify = justify;
	}

	public double getSpacing() {
		return spacing;
	}

	public void setSpacing(double spacing) {
		this.spacing = spacing;
	}
	
}
