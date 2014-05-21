package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Geometry;

public class Extrusion implements Geometry {
	
	private double[][] 		  spine;			//该域实际上定义了一条沿挤压方向上的主干线，通称为龙骨折线
	
	private double[][] crossSection;			//由一系列二维坐标点依次连接相邻的坐标点来定义一个二维折线，作为挤
												//压过程中的外部轮廓
	
	private double[] 		  scale;			//这个域定义二维折线的尺度沿 spine 挤压过程中缩放变换参数
	
	private double[][]  orientation;			//该域定义三维旋转变换参数。一般该域值的个数与 spine 域一样，顺序对应着每个龙骨构
												//造点处的二维折线的旋转变换
	
	private boolean 	   beginCap;			//该域确定挤压成型的造型是否有起始端面（对应 spine 的第一个值）。如果 beginCap 设置
												//为FALSE ，则不产生起始端面，否则，起始端面是将 crossSection 域中的二维折线首尾相连构
												//成的多边形表面
	
	private boolean 		 endCap;			//该域确定挤压成型的造型是否有终止端面（对应 spine 的最后一个值）
	
	private boolean 			ccw;			//Extrusion 节点自动生成几何面的法线，该域决定法线方向与二维折线走向的关系
	
	private boolean 		  solid;			//对于一个几何体的面，法线方向的表面被认为是“外”表面，与此相反的是“内”表面，
												//当 solid 域为 TRUE 时，只显示“外”表面，“内”表面并不显示着色
	
	private boolean 		 convex;			//该域确定挤压成型的几何体的起始端面和结束端面是凸起还是凹下。如果该值为 TRUE，
												//则端面是凸起的，否则，则表示端面为凹下的
	
	private double 		creaseAngle; 			//该域确定一个角度。决定浏览器对几何体相邻表面之间棱的处理。如果相邻表面法线之间
												//的夹角的绝对值小于这一角度，浏览器对相邻表面做平滑处理，棱是圆滑的，不能被明显地察
												//觉到
	
	protected final Map<String,Integer> required;		//必填属性

	protected final Map<String,Integer> exsisted;		//已存在属性
	
	
	public Extrusion(double[][] spine,double[][] crossSection){
		this(spine,crossSection,new double[0],new double[0][0],false,false,false,false,false,0.785);
	}
	
	public Extrusion(double[][] spine, double[][] crossSection, double[] scale,
			double[][] orientation, boolean beginCap, boolean endCap,
			boolean ccw, boolean solid, boolean convex, double creaseAngle) {
		this.spine = spine;
		this.crossSection = crossSection;
		this.scale = scale;
		this.orientation = orientation;
		this.beginCap = beginCap;
		this.endCap = endCap;
		this.ccw = ccw;
		this.solid = solid;
		this.convex = convex;
		this.creaseAngle = creaseAngle;
		
		required = new HashMap<>();
		required.put("spine", 0);
		required.put("crossSection", 0);
		
		exsisted = new HashMap<>();
		exsisted.put("spine", 0);
		exsisted.put("crossSection", 0);
		exsisted.put("scale", 1);
		exsisted.put("orientation", 1);
		exsisted.put("beginCap", 1);
		exsisted.put("endCap", 1);
		exsisted.put("ccw", 1);
		exsisted.put("solid", 1);
		exsisted.put("convex", 1);
		exsisted.put("creaseAngle", 1);
	}
	
	public double[][] getSpine() {
		return spine;
	}
	public void setSpine(double[][] spine) {
		this.spine = spine;
	}
	public double[][] getCrossSection() {
		return crossSection;
	}
	public void setCrossSection(double[][] crossSection) {
		this.crossSection = crossSection;
	}
	public double[] getScale() {
		return scale;
	}
	public void setScale(double[] scale) {
		this.scale = scale;
	}
	public double[][] getOrientation() {
		return orientation;
	}
	public void setOrientation(double[][] orientation) {
		this.orientation = orientation;
	}
	public boolean isBeginCap() {
		return beginCap;
	}
	public void setBeginCap(boolean beginCap) {
		this.beginCap = beginCap;
	}
	public boolean isEndCap() {
		return endCap;
	}
	public void setEndCap(boolean endCap) {
		this.endCap = endCap;
	}
	public boolean isCcw() {
		return ccw;
	}
	public void setCcw(boolean ccw) {
		this.ccw = ccw;
	}
	public boolean isSolid() {
		return solid;
	}
	public void setSolid(boolean solid) {
		this.solid = solid;
	}
	public boolean isConvex() {
		return convex;
	}
	public void setConvex(boolean convex) {
		this.convex = convex;
	}
	public double getCreaseAngle() {
		return creaseAngle;
	}
	public void setCreaseAngle(double creaseAngle) {
		this.creaseAngle = creaseAngle;
	}
}
