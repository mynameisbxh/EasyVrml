package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.extend.EventIn;
/*
 *在许多场景中有些类似于布告牌的东西，例如标牌等等。有的时候，在并非十分逼真的情
 *况下，树木、花卉等等往往使用在一个平面上贴图来实现，这样当在场景中移动视点的时候，
 *就有可能出现问题，树木往往可能是一个薄片，而看起来不再是一棵树。布告牌节点 Billboard
 *能够解决这个问题。
 */
public class Billboard implements Node {
	private Node[] 		   children;		//该域包含子节点的列表，子节点的类型即可以是单节点也可以是群节点
	
	private double[] axisOfRotation;  		//给出三个坐标值，由该点指向坐标原点确定的轴线规定一根旋转轴
	
	private double[]     bboxCenter;		//包围 Billboard 节点中所有子节点的区域的中心
	
	private double[]       bboxSize;		//包围 Billboard 节点中所有子节点的区域在 X、Y、Z 方向的尺寸
	
	protected final Map<String,Integer> required;		//必填属性

	protected final Map<String,Integer> exsisted;		//已存在属性
	
	public final EventIn 			addChildren;	//入事件，多值节点型。通过事件的驱动，将指定的节点加入到 Billboard 节点的子节点列表
													//中，如果该节点已经在列表中，则本事件被忽略。
	
	public final EventIn 		 removeChildren;	//入事件，多值节点型。通过事件的驱动，将指定的节点从 Billboard 节点的子节点列表中删
													//除，如果该节点没有在列表中，则本事件被忽略

	public Billboard(Node[] children) {
		this(children,new double[]{},new double[0],new double[0]);
	}

	public Billboard(Node[] children, double[] axisOfRotation,double[] bboxCenter, double[] bboxSize) {
		this.children = children;
		this.axisOfRotation = axisOfRotation;
		this.bboxCenter = bboxCenter;
		this.bboxSize = bboxSize;
		
		required = new HashMap<>();
		required.put("children", 0);
		
		exsisted = new HashMap<>();
		exsisted.put("children", 0);
		exsisted.put("axisOfRotation", 1);
		exsisted.put("bboxCenter", 1);
		exsisted.put("bboxSize", 1);
		
		this.addChildren = new EventIn("addChildren","MFNode");
		this.removeChildren = new EventIn("removeChildren","MFNode");
	}

	public Node[] getChildren() {
		return children;
	}

	public void setChildren(Node[] children) {
		this.children = children;
	}

	public double[] getAxisOfRotation() {
		return axisOfRotation;
	}

	public void setAxisOfRotation(double[] axisOfRotation) {
		this.axisOfRotation = axisOfRotation;
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

	public EventIn getAddChildren() {
		return addChildren;
	}

	public EventIn getRemoveChildren() {
		return removeChildren;
	}
	
}
