package com.bxh.easyvrml.generator;

import java.math.BigDecimal;
import java.util.Random;

import com.bxh.easyvrml.element.field.Point3D;
import com.bxh.easyvrml.node.basic.Color;
import com.bxh.easyvrml.node.basic.Coordinate;
import com.bxh.easyvrml.node.basic.IndexedFaceSet;
import com.bxh.easyvrml.node.basic.IndexedLineSet;
/**
 * 用于生成基于3维空间坐标的点集
 * 
 * @author BXH
 */
public class IndexedFaceSetGenerator {

	//
	public static IndexedFaceSet getIndexedFaceSet(Point3D start,Point3D end){
		IndexedFaceSet face = new IndexedFaceSet();
		face.setColor(new Color(new double[][]{{1.0,1.0,1.0},{1.0,1.0,1.0}}));
		face.setColorIndex(new int[]{0,1});
		face.setCoord(new Coordinate(new double[][]{{start.getX(),start.getY(),start.getZ()},{end.getX(),end.getY(),end.getZ()}}));
		face.setCoordIndex(new int[]{0,1,-1});
		face.setColorPerVertex(true);
		return face;
	}
	/**
	 * 获取一个指定四角坐标的平面
	 * @param _p1
	 * @param _p2
	 * @param _p3
	 * @param _p4
	 * @return
	 */
	public static IndexedFaceSet getFace(Point3D _p1,Point3D _p2,Point3D _p3,Point3D _p4){
		IndexedFaceSet face = new IndexedFaceSet();
		face.setCoord(new Coordinate(new double[][]{{_p1.getX(),_p1.getY(),_p1.getZ()},
												 {_p2.getX(),_p2.getY(),_p2.getZ()},
												 {_p3.getX(),_p3.getY(),_p3.getZ()},
												 {_p4.getX(),_p4.getY(),_p4.getZ()}}));
		face.setCoordIndex(new int[]{0,1,2,3,0,-1});
		
		face.setColor(new Color(new double[][]{{1.0,0.0,0.0},{1.0,0.0,0.0},{1.0,0.0,0.0},{1.0,0.0,0.0}}));
		face.setColorIndex(new int[]{0,1,2,3});
		
		return face;
	}
	/**
	 * 获取一个指定长宽的平面
	 * @param point
	 * @param width
	 * @param length
	 * @return
	 */
	public static IndexedFaceSet getPanel(Point3D point,double width,double length){
		IndexedFaceSet face = new IndexedFaceSet();
		face.setCoord(new Coordinate(new double[][]{{point.getX()+width/2,point.getY(),point.getZ()+length/2},
												 {point.getX()+width/2,point.getY(),point.getZ()-length/2},
												 {point.getX()-width/2,point.getY(),point.getZ()-length/2},
												 {point.getX()-width/2,point.getY(),point.getZ()+length/2}}));
		face.setCoordIndex(new int[]{0,1,2,3,0,-1});
		
		face.setColor(new Color(new double[][]{{1.0,0.0,0.0},{1.0,0.0,0.0},{1.0,0.0,0.0},{1.0,0.0,0.0}}));
		face.setColorIndex(new int[]{0,1,2,3});
		
		return face;
	}
}
