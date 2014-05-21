package com.bxh.easyvrml.node.basic;

import com.bxh.easyvrml.impl.Geometry;

public class IndexedFaceSet implements Geometry {
	private Coordinate 			 coord;				//这个域的用法同线集合节点 IndexedLineSet 情况类似，只是这个域用来提供空间平面多边
													//形的顶点的点坐标
	
	private int[] 			coordIndex;				//对应 Coordinate 节点的 point 域的坐标列表的一个索引列表，按给定的索引顺序连接坐标
													//点形成空间的多边形
	
	private TextureCoordinate texCoord;				//这个域包含一个 TextureCoordinate 节点，指明将一幅纹理图片映射到面集表面上
	
	private int[]		 texCoordIndex; 			//对应 TextureCoordinate 节点的索引列表
	
	private Color				 color;				//域值是 Color 节点，Color 节点的域值也是 color，它列出了用于为每个面的顶点的坐标点
													//着色的一个颜色列表
	
	private int[]			colorIndex;				//对应 Color 节点的 color 域值的索引列表
	
	private boolean 	colorPerVertex;				//如果在 color 域有一个 Color 节点给出了颜色列表， 则这个域的域值指明是把对应的颜色赋
													//给每个顶点，还是赋给每个表面
	
	private Normal				normal;				//这个域含一个 Normal 节点，给出了给表面指定法线向量的值
	
	private int[]		   normalIndex;				//对应于 Normal 节点的索引的列表，由索引的排列顺序决定了表面法线向量的方向排列
	
	private boolean	   normalPerVertex;				//指明是否已为每个顶点还是给每个表面确定了法向量
	
	private boolean 			   ccw;				//按照右手螺旋法则指明每个表面上的顶点的排列走向
	
	private boolean				 solid;				//指定用户是否能看见表面的背面
	
	private boolean				convex;				//设定所构建的表面是凸的还是凹的
	
	private double		   creaseAngle;				//确定一个转折角，当相邻两个表面的夹角小于这个角度的时候，则相邻两表面间的边界平
													//滑过渡，即棱角看起来不那么尖锐

	public IndexedFaceSet(){
		coord = new Coordinate();
		coordIndex = new int[0];
		texCoord = new TextureCoordinate();
		texCoordIndex = new int[0];
		color = new Color();
		colorIndex = new int[0];
		normal = new Normal();
		normalIndex = new int[0];
	}
	
	public IndexedFaceSet(Coordinate coord, int[] coordIndex,TextureCoordinate texCoord, int[] texCoordIndex, Color color,
			int[] colorIndex, boolean colorPerVertex, Normal normal,int[] normalIndex, boolean normalPerVertex, boolean ccw,
			boolean solid, boolean convex, double creaseAngle) {
		super();
		this.coord = coord;
		this.coordIndex = coordIndex;
		this.texCoord = texCoord;
		this.texCoordIndex = texCoordIndex;
		this.color = color;
		this.colorIndex = colorIndex;
		this.colorPerVertex = colorPerVertex;
		this.normal = normal;
		this.normalIndex = normalIndex;
		this.normalPerVertex = normalPerVertex;
		this.ccw = ccw;
		this.solid = solid;
		this.convex = convex;
		this.creaseAngle = creaseAngle;
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

	public TextureCoordinate getTexCoord() {
		return texCoord;
	}

	public void setTexCoord(TextureCoordinate texCoord) {
		this.texCoord = texCoord;
	}

	public int[] getTexCoordIndex() {
		return texCoordIndex;
	}

	public void setTexCoordIndex(int[] texCoordIndex) {
		this.texCoordIndex = texCoordIndex;
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

	public Normal getNormal() {
		return normal;
	}

	public void setNormal(Normal normal) {
		this.normal = normal;
	}

	public int[] getNormalIndex() {
		return normalIndex;
	}

	public void setNormalIndex(int[] normalIndex) {
		this.normalIndex = normalIndex;
	}

	public boolean isNormalPerVertex() {
		return normalPerVertex;
	}

	public void setNormalPerVertex(boolean normalPerVertex) {
		this.normalPerVertex = normalPerVertex;
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
