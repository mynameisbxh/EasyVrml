package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.extend.EventIn;
import com.bxh.easyvrml.node.extend.EventOut;

/**
 * 在 VRML 中，还有一个群节点 Collision，因为它能够容纳别的节点作为自己的子节点。但
 *是这个群节点主要是作为感知器作用，处理并且响应浏览者和场景中的虚拟对象非常接近时的
 *现象。更多的时候，Collision 起到这样现象的检测，并且做出响应，在后面讨论感知器的时候
 *再来重点学习这个节点
 *
 * @author BXH
 */
public class Collision implements Node {
	private Node[]		 children;  		//包含节点或者节点组，这些节点和节点组将作为被检测碰撞的对象
	
	private boolean		  collide;			//确定节点的子节点是否要接收碰撞检测。如果是 TRUE，则要接受碰撞检测
	
	private Node		    proxy;			//作为一个代理，取代 children 域中接受碰撞检测的子节点对象
	
	private double[] bboxCenter;			//包围 Collision 节点的所有子节点的区域的中心
	
	private double[]   bboxSize;			//包围 Collision 节点的所有子节点的区域在 X、Y、Z 方向上的尺寸
	
	protected Map<String, Integer> required; // 必填属性

	protected Map<String, Integer> exsisted; // 已存在属性
	
	public final EventIn 	  addChildren;			//输入事件，多值节点型。将指定的节点加入到 Collision 节点的子节点列表中
	
	public final EventIn removeChildren;			//输入事件，多值节点型。将指定节点从 Collision 节点的子节点列表中删除
	
	public final EventOut   collideTime;			//输出事件，单值时间型。输出检测到的碰撞发生的时间。
	
	public Collision(Node[] children,Node proxy) {
		this(children,true,proxy,new double[]{0.0,0.0,0.0},new double[]{-1,-1,-1});
	}
	
	public Collision(Node[] children, boolean collide, Node proxy,double[] bboxCenter, double[] bboxSize) {
		this.children = children;
		this.collide = collide;
		this.proxy = proxy;
		this.bboxCenter = bboxCenter;
		this.bboxSize = bboxSize;
		
		required = new HashMap<>();
		required.put("children", 0);
		required.put("proxy", 0);
		
		exsisted = new HashMap<>();
		exsisted.put("children", 1);
		exsisted.put("collide", 1);
		exsisted.put("proxy", 0);
		exsisted.put("bboxCenter", 1);
		exsisted.put("bboxSize", 1);
		
		addChildren = new EventIn("addChildren","MFNode");
		removeChildren = new EventIn("removeChildren","MFNode");
		collideTime = new EventOut("collideTime","SFTime");
	}
	public Node[] getChildren() {
		return children;
	}
	public void setChildren(Node[] children) {
		this.children = children;
	}
	public boolean isCollide() {
		return collide;
	}
	public void setCollide(boolean collide) {
		this.collide = collide;
	}
	public Node getProxy() {
		return proxy;
	}
	public void setProxy(Node proxy) {
		this.proxy = proxy;
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

	public EventOut getCollideTime() {
		return collideTime;
	}
}
