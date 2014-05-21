package com.bxh.easyvrml.node.basic;

import com.bxh.easyvrml.impl.Geometry;

/**
 * ElevationGrid 用于表示地形
 * 
 * @author BXH
 */
public class ElevationGrid implements Geometry {

	private int 			xDimension;				//X 方向上的顶点数，不能为负值
	
	private double 			  xSpacing;				//X 方向的顶点之间的距离，不能为负值
	
	private int 			zDimension;				//Z 方向上的顶点数，不能为负值
	
	private double 			  zSpacing;				//Z 方向的顶点之间的距离，不能为负值
	
	private double[] 			height;				//定义对应于前面的顶点一系列的高度值(即 Y 坐标值)
	
	private Color 				 color;				//域值是一个 Color 节点，如果想为每个四边形或每个顶点添加颜色，可以使用这个节点设
													//置一个颜色列表。
	
	private boolean 	colorPerVertex;				//确定是否为每个顶点还是为每个四边形添加颜色
	
	private Normal				normal;				//表面法线向量是用来确定表面的朝向的，如果希望为网格定义法向量，可包含一个向量节
													//点 Normal，该节点包含一个 vector 域，用来给定向量值
	
	private boolean    normalPerVertex;				//这个域确定是为每个顶点还是每个四边形也就是网格提供一个法向量
	
	private TextureCoordinate texCoord;				//包含一个 TextureCoordinate 节点，用来将一个纹理贴到网格上
	
	private boolean 			   ccw;				//是表示一个右手定则的含义，就是说如果逆时针建立边界，拇指方向即为正方向，也就是
													//使网格面正面朝上，和 Y  的正方向一致
	
	private boolean 			 solid;				//指出背面是否可见，也就是说是否两面都创建
	
	private double 		   creaseAngle;				//设定一个角度，当相邻两个平面之间的夹角小于该角度时，则 相邻两平面有平滑的过渡角

	public ElevationGrid(){
		texCoord = new TextureCoordinate();
		normal = new Normal();
	}
	
	public ElevationGrid(int xDimension, double xSpacing, int zDimension,double zSpacing, double[] height, Color color,
			boolean colorPerVertex, Normal normal, boolean normalPerVertex,TextureCoordinate texCoord, boolean ccw, boolean solid,
			double creaseAngle) {
		super();
		this.xDimension = xDimension;
		this.xSpacing = xSpacing;
		this.zDimension = zDimension;
		this.zSpacing = zSpacing;
		this.height = height;
		this.color = color;
		this.colorPerVertex = colorPerVertex;
		this.normal = normal;
		this.normalPerVertex = normalPerVertex;
		this.texCoord = texCoord;
		this.ccw = ccw;
		this.solid = solid;
		this.creaseAngle = creaseAngle;
	}


	public int getxDimension() {
		return xDimension;
	}

	public void setxDimension(int xDimension) {
		this.xDimension = xDimension;
	}

	public double getxSpacing() {
		return xSpacing;
	}

	public void setxSpacing(double xSpacing) {
		this.xSpacing = xSpacing;
	}

	public int getzDimension() {
		return zDimension;
	}

	public void setzDimension(int zDimension) {
		this.zDimension = zDimension;
	}

	public double getzSpacing() {
		return zSpacing;
	}

	public void setzSpacing(double zSpacing) {
		this.zSpacing = zSpacing;
	}

	public double[] getHeight() {
		return height;
	}

	public void setHeight(double[] height) {
		this.height = height;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
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

	public boolean isNormalPerVertex() {
		return normalPerVertex;
	}

	public void setNormalPerVertex(boolean normalPerVertex) {
		this.normalPerVertex = normalPerVertex;
	}

	public TextureCoordinate getTexCoord() {
		return texCoord;
	}

	public void setTexCoord(TextureCoordinate texCoord) {
		this.texCoord = texCoord;
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

	public double getCreaseAngle() {
		return creaseAngle;
	}

	public void setCreaseAngle(double creaseAngle) {
		this.creaseAngle = creaseAngle;
	}
	
}
