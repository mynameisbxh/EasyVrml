package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;

public class Background implements Node {
	private double[][]	groundColor;		//用于指定给地面球体着色的 RGB 值。可以设定一系列的颜色值以便形成按水平分层渐变
											//的效果。其中所列出的第一个颜色值是指垂直向下看到的那个点的颜色
	
	private double[]	groundAngle;		//指定一系列以弧度表示的角度值，这些角度值对应上述 groundColor 域内给出的一系列颜
											//色值
	
	private double[][]	   skyColor;		//用于指定天空球体着色的 RGB 值。可以设定一系列的颜色值以便形成按水平分层渐变的
											//效果。所列出的第一个值是对应竖直向上看那一点的颜色
	
	private double[]       skyAngle;		//指定一系列以弧度表示的角度值， 这些角度值对应上述 skyColor 域内给出的一系列颜色值
	
	private String[]	   frontUrl;		//分别指定将被映射到空间立方体各个面上的图像的路径，以添加背景图片
	
	private String[]	    backUrl;		
	
	private String[]       rightUrl;		
	
	private String[]		leftUrl;		
	
	private String[]		 topUrl;		
	
	private String[]	  bottomUrl;		
	
	protected final Map<String,Integer> required;		//必填属性

	protected final Map<String,Integer> exsisted;		//已存在属性
	
	
	public Background() {
//		this(new double[][]{{1.0,1.0,1.0}},
//			 new double[]{1.309,1.571},
//			 new double[][]{{1.0,1.0,1.0}},
//			 new double[]{1.309,1.571},
//			 new String[0],
//			 new String[0],
//			 new String[0],
//			 new String[0],
//			 new String[0],
//			 new String[0]);
		this(new double[][]{{0.0,0.2,0.7},
							{0.0,0.5,1.0},
							{1.0,1.0,1.0}},
			 new double[]{1.309,1.571},
			 new double[][]{
				{0.1,0.15,0.0},
				{0.4,0.25,0.2},
				{0.5,0.55,0.5}},
			 new double[]{1.309,1.571},
			 new String[0],
			 new String[0],
			 new String[0],
			 new String[0],
			 new String[0],
			 new String[0]);
	}

	public Background(double[][] groundColor, double[] groundAngle,double[][] skyColor, double []skyAngle, String[] frontUrl,
			String[] backUrl, String[] rightUrl, String[] leftUrl,String[] topUrl, String[] bottomUrl) {
		this.groundColor = groundColor;
		this.groundAngle = groundAngle;
		this.skyColor = skyColor;
		this.skyAngle = skyAngle;
		this.frontUrl = frontUrl;
		this.backUrl = backUrl;
		this.rightUrl = rightUrl;
		this.leftUrl = leftUrl;
		this.topUrl = topUrl;
		this.bottomUrl = bottomUrl;
		required = new HashMap<>();
		
		exsisted = new HashMap<>();
		exsisted.put("groundColor", 1);
		exsisted.put("groundAngle", 1);
		exsisted.put("skyColor", 1);
		exsisted.put("skyAngle", 1);
		exsisted.put("frontUrl", 1);
		exsisted.put("backUrl", 1);
		exsisted.put("rightUrl", 1);
		exsisted.put("leftUrl", 1);
		exsisted.put("topUrl", 1);
	}
	
	public double[][] getGroundColor() {
		return groundColor;
	}
	public void setGroundColor(double[][] groundColor) {
		this.groundColor = groundColor;
	}
	public double[] getGroundAngle() {
		return groundAngle;
	}
	public void setGroundAngle(double[] groundAngle) {
		this.groundAngle = groundAngle;
	}
	public double[][] getSkyColor() {
		return skyColor;
	}
	public void setSkyColor(double[][] skyColor) {
		this.skyColor = skyColor;
	}
	public double[] getSkyAngle() {
		return skyAngle;
	}
	public void setSkyAngle(double[] skyAngle) {
		this.skyAngle = skyAngle;
	}
	public String[] getFrontUrl() {
		return frontUrl;
	}
	public void setFrontUrl(String[] frontUrl) {
		this.frontUrl = frontUrl;
	}
	public String[] getBackUrl() {
		return backUrl;
	}
	public void setBackUrl(String[] backUrl) {
		this.backUrl = backUrl;
	}
	public String[] getRightUrl() {
		return rightUrl;
	}
	public void setRightUrl(String[] rightUrl) {
		this.rightUrl = rightUrl;
	}
	public String[] getLeftUrl() {
		return leftUrl;
	}
	public void setLeftUrl(String[] leftUrl) {
		this.leftUrl = leftUrl;
	}
	public String[] getTopUrl() {
		return topUrl;
	}
	public void setTopUrl(String[] topUrl) {
		this.topUrl = topUrl;
	}
	public String[] getBottomUrl() {
		return bottomUrl;
	}
	public void setBottomUrl(String[] bottomUrl) {
		this.bottomUrl = bottomUrl;
	}
	
}
