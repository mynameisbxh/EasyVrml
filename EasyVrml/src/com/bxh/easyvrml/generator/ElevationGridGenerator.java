package com.bxh.easyvrml.generator;

import java.math.BigDecimal;
import java.util.Random;

import com.bxh.easyvrml.element.field.Point3D;
import com.bxh.easyvrml.node.basic.Color;
import com.bxh.easyvrml.node.basic.Coordinate;
import com.bxh.easyvrml.node.basic.ElevationGrid;
import com.bxh.easyvrml.tools.MathUtils;
/**
 * 用于生成基于3维空间坐标的点集
 * 
 * @author BXH
 */
public class ElevationGridGenerator {

	//获得一个指定数量的颜色集
	public static ElevationGrid getRandomElevationGrid(int xDimension, double xSpacing, int zDimension,double zSpacing,double scale){
		ElevationGrid elevation = new ElevationGrid();
		double []height = new double[xDimension*zDimension]; 
		Random ran = new Random();
		for(int i=0;i<height.length;i++){
			height[i] = MathUtils.divide(ran.nextDouble()*scale);
		}
		elevation.setHeight(height);
		elevation.setCreaseAngle(1.0);
		elevation.setColorPerVertex(false);
		elevation.setxDimension(xDimension);
		elevation.setxSpacing(xSpacing);
		elevation.setzDimension(zDimension);
		elevation.setzSpacing(zSpacing);
		//elevation.setColor(ColorGenerator.getRandomColor(xDimension*zDimension));
		elevation.setColor(ColorGenerator.getSingleColor(xDimension*zDimension, new double[]{1.0,0.0,0.0}));
		return elevation;
	}
}
