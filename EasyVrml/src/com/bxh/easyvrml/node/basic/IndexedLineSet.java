package com.bxh.easyvrml.node.basic;

import java.util.HashMap;
import java.util.Map;

import com.bxh.easyvrml.impl.Geometry;
import com.bxh.easyvrml.node.extend.EventIn;

public class IndexedLineSet implements Geometry {
	private  Coordinate	     coord;			//用来提供空间线段的顶点的点坐标
	
	private  int[] 	    coordIndex;			//对应 Coordinate 节点的 point 域的坐标列表的一个索引列表， 按给定的索引顺序连接坐标点
											//在场景中构建复杂造型形成线段或者折线
	
	private  Color 		     color;			//域值是 Color 节点，Color 节点的域值也是 color，它列出了用于作为每个线段的顶点的坐
											//标点着色的一个颜色列表
	
	private  int[] 	    colorIndex; 		//对应 Color 节点的 color 域值的索引列表
	
	private boolean colorPerVertex;			//如果在 color 域有一个 Color 节点给出了颜色列表， 则这个域的域值指明是把对应的颜色赋
											//给每个顶点，还是赋给每条折线
	
	protected final Map<String,Integer> required;		//必填属性

	protected final Map<String,Integer> exsisted;		//已存在属性
	
	public IndexedLineSet(){
		required = new HashMap<>();

		exsisted = new HashMap<>();
		exsisted.put("coord", 0);
		exsisted.put("coordIndex", 0);
		exsisted.put("color", 0);
		exsisted.put("colorIndex", 0);
		exsisted.put("colorPerVertex", 1);
	}
	
	public IndexedLineSet(Coordinate coord,int[] coordIndex,Color color,int[] colorIndex,boolean colorPerVertex){
		this.coord = coord;
		this.colorIndex = coordIndex;
		this.color = color;
		this.colorIndex = colorIndex;
		this.colorPerVertex = colorPerVertex;
		
		required = new HashMap<>();

		exsisted = new HashMap<>();
		exsisted.put("coord", 0);
		exsisted.put("colorIndex", 0);
		exsisted.put("color", 0);
		exsisted.put("colorIndex", 0);
		exsisted.put("colorPerVertex", 1);
	}

	public Coordinate getCoord() {
		return coord;
	}

	public void setCoord(Coordinate coord) {
		this.coord = coord;
	}

	public int[] getCoordIndex() {
		return coordIndex;
	}

	public void setCoordIndex(int[] coordIndex) {
		this.coordIndex = coordIndex;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int[] getColorIndex() {
		return colorIndex;
	}

	public void setColorIndex(int[] colorIndex) {
		this.colorIndex = colorIndex;
	}

	public boolean isColorPerVertex() {
		return colorPerVertex;
	}

	public void setColorPerVertex(boolean colorPerVertex) {
		this.colorPerVertex = colorPerVertex;
	}
	
}
