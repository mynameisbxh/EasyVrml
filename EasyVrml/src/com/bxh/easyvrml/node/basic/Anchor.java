package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.extend.EventIn;

public class Anchor implements Node {

	private Node[]			children;			//列在该域中的子节点作为指向在 url 域中指定的其他文件的超级链接的锚点
	
	private String[]	 description;			//超级链接的文本提示。移动光标到锚点对象而不点击它时，浏览器显示提示文本，以给用
												//户提供必要的说明。
	
	private String[] 	   parameter;			//为 VRML 和 HTML 浏览器附加的信息,是一个形如标记语言的字符串格式为“ 关键词=值”
												//的形式
	
	private String[]			 url;			//指定要链接装入的文件的路径
	
	private double[]	  bboxCenter;			//包围 Anchor 中所有子节点对象的包围区域的中心
	
	private double[]		bboxSize;			//包围 Anchor 中所有子节点对象的包围区域在 X、Y、Z 方向上的尺寸

	protected final Map<String,Integer> required;		//必填属性

	protected final Map<String,Integer> exsisted;		//已存在属性
	
	public final EventIn 		addChildren;			//入事件，多值节点型。由外界事件驱动，在 Anchor 节点的 children 域中子节点序列中加入
												//指定的节点。如果指定子节点已经存在于子节点序列中，则忽略本事件
	
	public final EventIn	 removeChildren;			//入事件，多值节点型。在 A nchor 节点的 children 域中子节点序列中删除指定的节点。如果
												//指定子节点不在子节点序列中，则忽略本事件。 
	
	
	public Anchor(Node[] children,String[] url) {
		this(children,new String[]{"Anchor"},new String[]{""},url,new double[3],new double[3]);
	}

	public Anchor(Node[] children, String[] description, String[] parameter,
			String[] url, double[] bboxCenter, double[] bboxSize) {
		this.children = children;
		this.description = description;
		this.parameter = parameter;
		this.url = url;
		this.bboxCenter = bboxCenter;
		this.bboxSize = bboxSize;
		
		required = new HashMap<>();
		required.put("children", 0);
		required.put("url", 0);
		
		exsisted = new HashMap<>();
		exsisted.put("children", 0);
		exsisted.put("url", 1);
		exsisted.put("description", 1);
		exsisted.put("parameter", 1);
		exsisted.put("bboxCenter", 2);
		exsisted.put("bboxSize", 2);
		
		this.addChildren = new EventIn("addChildren","MFNode");
		this.removeChildren = new EventIn("removeChildren","MFNode");
	}

	public Node[] getChildren() {
		return children;
	}

	public void setChildren(Node[] children) {
		this.children = children;
	}

	public String[] getDescription() {
		return description;
	}

	public void setDescription(String[] description) {
		this.description = description;
	}

	public String[] getParameter() {
		return parameter;
	}

	public void setParameter(String[] parameter) {
		this.parameter = parameter;
	}

	public String[] getUrl() {
		return url;
	}

	public void setUrl(String[] url) {
		this.url = url;
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
	
}
