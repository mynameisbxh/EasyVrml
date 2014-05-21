package com.bxh.easyvrml.generator;

import java.math.BigDecimal;
import java.util.Random;

import com.bxh.easyvrml.element.field.Point3D;
import com.bxh.easyvrml.node.basic.Coordinate;
import com.bxh.easyvrml.tools.MathUtils;
/**
 * 用于生成基于3维空间坐标的点集
 * 
 * @author BXH
 */
public class CoordinateGenerator {

	//获得一个指定长、宽、高区域内的节点集
	public static Coordinate getRandomCoordinate(double _length,double _width,double _height,Point3D originPoint,int count){
		Coordinate coord = new Coordinate();
		double [][]points = new double[count][3]; 
		Random ran = new Random();
		for(int i=0;i<count;i++){
			points[i][0] = MathUtils.divide((ran.nextDouble() -0.5)*_length + originPoint.getX());
			points[i][1] = MathUtils.divide((ran.nextDouble() -0.5)* _width + originPoint.getY());
			points[i][2] = MathUtils.divide((ran.nextDouble() -0.5)*_height + originPoint.getZ());
		}
		coord.setPoint(points);
		return coord;
	}
	
}
