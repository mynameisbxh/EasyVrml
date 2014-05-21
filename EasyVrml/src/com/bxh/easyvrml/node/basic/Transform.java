package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.extend.EventIn;
import com.bxh.easyvrml.node.extend.EventOut;
/**
 * 	    局部坐标系里，所有的子坐标系都是相对于同一个父坐标系而创建的，父坐标系是整个坐
 *标系群的最高一级。这时候，每个造型都有自己的坐标系，但是所有的子坐标系都是相对于这
 *个共同的父坐标系而定位。
 *	    多坐标系里，各个子坐标系也都有父坐标系，但是父坐标系不是对于所有的子坐标系共同
 *的，每一个子坐标系都有自己的父坐标系。子坐标系、父坐标系层层嵌套，形成一个坐标系族。
 *在这个坐标系族里，每一个子坐标系的创建都是相对于它自己的父坐标定位。
 *	    在创建场景的时候，需要应用坐标变换的场合，既可以用局部坐标系，也可以用多坐标系
 *系统，也可以两种坐标系混用。完全取决于编程和建模的方便。
 *
 * @author BXH
 */
public class Transform implements Node {
	 private double[]       bboxCenter;		  //围绕所有变换子节点的包围区域的中心
	
	 private double[]         bboxSize;       //包围区域在 X、Y、Z 方向的值，缺省值是无包围区域，由浏览器自己去计算
	
	 private double[]      translation;		  //该域值决定坐标平移的新位置，无论多坐标系还是局部坐标系系统，给出的都是子坐标系
	 										  //的原点在父坐标系中的位置
	
	 private double[]         rotation;		  //给定坐标系旋转中旋转的轴和绕轴旋转的角度,前三个坐标点与父坐标原点的连线决定旋
	 										  //转轴，第四个量决定以弧度值表示的旋转的角度
	 
	 private double[]		     scale;		  //指定沿各个坐标轴缩放的比例，各坐标轴方向上缩放比率可以不相等
	 
	 private double[] scaleOrientation;       //指定旋转方向的缩放，当定义出了缩放尺度后，再对所选择的旋转方向进行缩放
	
	 private double[]           center;		  //指定缩放和旋转操作的中心点
	 
	 private Node[]           children;  	  //指定受 Transform 节点的各种变换影响的子节点的列表，这里的子节点可以是寻常的节点，
	 										  //也可以是群节点，也可以包括 Transform 节点

	 protected final Map<String,Integer> required;		//必填属性

	 protected final Map<String,Integer> exsisted;		//已存在属性
	 
	 public final EventIn etranslation;
		
	 public Transform() {
		required = new HashMap<>();
		required.put("children", 0);
		
		exsisted = new HashMap<>();
		exsisted.put("bboxCenter", 1);
		exsisted.put("bboxSize", 1);
		exsisted.put("translation", 1);
		exsisted.put("rotation", 1);
		exsisted.put("scale", 1);
		exsisted.put("scaleOrientation", 1);
		exsisted.put("center", 1);
		exsisted.put("children", 0);
		
		etranslation = new EventIn("translation","SFFloat");
	 }
	 
	public Transform(Node children) {
		this(new double[0],new double[0],new double[]{0,0,0},new double[]{0,0,0,0},new double[0],new double[0],new double[0],new Node[]{children});
	}
	 
	public Transform(Node[] children) {
		this(new double[0],new double[0],new double[0],new double[0],new double[0],new double[0],new double[0],children);
	}
	 
	public Transform(double[] bboxCenter, double[] bboxSize,double[] translation, double[] rotation, double[] scale,
			double[] scaleOrientation, double[] center, Node[] children) {
		this.bboxCenter = bboxCenter;
		this.bboxSize = bboxSize;
		this.translation = translation;
		this.rotation = rotation;
		this.scale = scale;
		this.scaleOrientation = scaleOrientation;
		this.center = center;
		this.children = children;
		
		required = new HashMap<>();
		required.put("children", 0);
		
		exsisted = new HashMap<>();
		exsisted.put("bboxCenter", 1);
		exsisted.put("bboxSize", 1);
		exsisted.put("translation", 1);
		exsisted.put("rotation", 1);
		exsisted.put("scale", 1);
		exsisted.put("scaleOrientation", 1);
		exsisted.put("center", 1);
		exsisted.put("children", 0);
		
		etranslation = new EventIn("translation","SFFloat");
	}

	public double[] getBboxCenter() {
		return bboxCenter;
	}

	public void setBboxCenter(double[] bboxCenter) {
		this.bboxCenter = bboxCenter;
	}

	public double[] getBboxSize() {
		return bboxSize;
	}

	public void setBboxSize(double[] bboxSize) {
		this.bboxSize = bboxSize;
	}

	public double[] getTranslation() {
		return translation;
	}

	public void setTranslation(double[] translation) {
		this.translation = translation;
	}

	public double[] getRotation() {
		return rotation;
	}

	public void setRotation(double[] rotation) {
		this.rotation = rotation;
	}

	public double[] getScale() {
		return scale;
	}

	public void setScale(double[] scale) {
		this.scale = scale;
	}

	public double[] getScaleOrientation() {
		return scaleOrientation;
	}

	public void setScaleOrientation(double[] scaleOrientation) {
		this.scaleOrientation = scaleOrientation;
	}

	public double[] getCenter() {
		return center;
	}

	public void setCenter(double[] center) {
		this.center = center;
	}

	public Node[] getChildren() {
		return children;
	}

	public void setChildren(Node[] children) {
		this.children = children;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public EventIn getEtranslation() {
		return etranslation;
	}
}
