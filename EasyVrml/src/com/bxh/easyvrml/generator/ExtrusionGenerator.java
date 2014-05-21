package com.bxh.easyvrml.generator;

import java.lang.reflect.Field;

import com.bxh.easyvrml.element.field.Point3D;
import com.bxh.easyvrml.impl.Geometry;
import com.bxh.easyvrml.node.basic.Coordinate;
import com.bxh.easyvrml.node.basic.Extrusion;
import com.bxh.easyvrml.node.basic.IndexedLineSet;
import com.bxh.easyvrml.tools.ColorConfig;

public class ExtrusionGenerator {

	/**
	 * 获得一个条由起始点和终结点确定的空间直线柱
	 * @param start
	 * @param end
	 * @return
	 */
//	public static Extrusion getLine(Point3D start,Point3D end,double radius){
//		Extrusion _ext = new Extrusion(new double[][]{}, crossSection)
//		return line;
//	}
	
	/**
	 * 通过一个IndexedLineSet对象获取其中的连接线点集（龙骨）
	 * @param geometry
	 * @return
	 */
	public static double[][] getSpineByIndexedLineSet(Geometry geometry){
		try {
			Field coord = geometry.getClass().getDeclaredField("coord");
			coord.setAccessible(true);
			Coordinate _coord = (Coordinate)coord.get(geometry);
			return _coord.getPoint();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 通过一个IndexedLineSet对象获取其模板
	 * @param geometry
	 * @return
	 */
	public static double[][] getCrossSectionByIndexedLineSet(Geometry geometry){
		try {
			Field coord = geometry.getClass().getDeclaredField("coord");
			coord.setAccessible(true);
			Coordinate _coord = (Coordinate)coord.get(geometry);
			double coordinate[][] = _coord.getPoint();
			if(coordinate!=null){
				double _coordinate[][] = new double[coordinate.length+1][2];
				for(int i = 0;i<coordinate.length;i++){
					_coordinate[i][0] = coordinate[i][0];
					_coordinate[i][1] = coordinate[i][1];
				}
				_coordinate[coordinate.length][0] = coordinate[0][0];
				_coordinate[coordinate.length][1] = coordinate[0][1];
				return _coordinate;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 
	 * @param start
	 * @param end
	 * @param count
	 * @return
	 */
	public static double[][] getLineSpine(Point3D start,Point3D end,int count){
		if(start.getX() == end.getX() && start.getY() == end.getY() && start.getZ() == end.getZ()){
			return null;
		}
		if(start.getX() == end.getX()){
			if(start.getY() == end.getY()){
				
			}else{
				
			}
		}
		double length = Math.sqrt(Math.pow(end.getX()-start.getX(), 2)+Math.pow(end.getY()-start.getY(), 2)+Math.pow(end.getZ()-start.getZ(), 2));
		double step = length/count;
//		for(int ){
//			
//		}
		return null;
	}
}
