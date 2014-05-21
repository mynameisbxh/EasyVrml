package com.bxh.easyvrml.generator;

import java.math.BigDecimal;
import java.util.Random;

import com.bxh.easyvrml.element.field.Point3D;
import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.basic.Color;
import com.bxh.easyvrml.node.basic.Coordinate;
import com.bxh.easyvrml.node.basic.Transform;
import com.bxh.easyvrml.node.extend.Rotation;
import com.bxh.easyvrml.tools.ColorConfig;
import com.bxh.easyvrml.tools.MathUtils;
import com.bxh.easyvrml.tools.Matrix;
import com.bxh.easyvrml.tools.VrmlUtils;
/**
 * 用于生成基于3维空间坐标的点集
 * 
 * @author BXH
 */
public class TransformGenerator {
	
	public static Point3D getRotatedLocation(Point3D point,Rotation rotation){
//		double _x = rotation.getX();
//		double _y = rotation.getY();
//		double _z = rotation.getZ();
		double _sin = Math.sin(VrmlUtils.getDegree(rotation.getDegree()));
		double _cos = Math.cos(VrmlUtils.getDegree(rotation.getDegree()));
		
//		double _v0 = _z*_z*(1 - _cos) + _cos;
//		double _v1 = _x*_y*(1 - _cos) - _z*_sin;
//		double _v2 = _x*_z*(1 - _cos) + _y*_sin;
//		
//		double _v3 = _x*_y*(1 - _cos) + _z*_sin;
//		double _v4 = _y*_y*(1 - _cos) + _cos;
//		double _v5 = _y*_z*(1 - _cos) - _x*_sin;
//		
//		double _v6 = _x*_z*(1 - _cos) - _y*_sin;
//		double _v7 = _y*_z*(1 - _cos) + _x*_sin;
//		double _v8 = _z*_z*(1 - _cos) + _cos;
		
//		_v0 = Math.abs(_v0)<0.001?0:_v0;
//		_v1 = Math.abs(_v1)<0.001?0:_v1;
//		_v2 = Math.abs(_v2)<0.001?0:_v2;
//		
//		_v3 = Math.abs(_v3)<0.001?0:_v3;
//		_v4 = Math.abs(_v4)<0.001?0:_v4;
//		_v5 = Math.abs(_v5)<0.001?0:_v5;
		
//		_v6 = Math.abs(_v6)<0.001?0:_v6;
//		_v7 = Math.abs(_v7)<0.001?0:_v7;
//		_v8 = Math.abs(_v8)<0.001?0:_v8;
		_cos = Math.abs(_cos)<0.001?0:_cos;
		_sin = Math.abs(_sin)<0.001?0:_sin;
		
		Matrix _mat0 = new Matrix(4, 4);
		_mat0.setValues(new double[][]{{_cos,_sin,0,0},
									   {-_sin,_cos,0,0},
									   {0,0,1,0},
									   {0,0,0,1}});
		Matrix _mat1 = new Matrix(1, 4);
		_mat1.setValues(new double[][]{{point.getX(),point.getY(),point.getZ(),1}});
		
		Matrix _mat2 = _mat1.multipMatrix(_mat0);
		
		double [][]_v = _mat2.getValues();
		return new Point3D(_v[0][0],_v[0][1],_v[0][2]);
	}
	
	public static Transform moveAndRotateNodeTo(Node node,Point3D point,Rotation rotation){
		return TransformGenerator.rotateNode(TransformGenerator.moveNodeTo(node, point), rotation);
	}
	
	//移动节点到新的位置
	public static Transform moveNodeTo(Node node,Point3D point){
		return moveNodeTo(new Node[]{node},point);
	}
	
	//移动节点到新的位置
	public static Transform moveNodeTo(Node []nodes,Point3D point){
		Transform tran = new Transform();
		tran.setChildren(nodes);
		tran.setTranslation(new double[]{point.getX(),point.getY(),point.getZ()});
		return tran;
	}
	/**
	 * 移动节点位置
	 * @param tran
	 * @param point
	 * @return
	 */
	public static Transform moveNodeTo(Transform tran,Point3D point){
		tran.setTranslation(new double[]{point.getX(),point.getY(),point.getZ()});
		return tran;
	}
	/**
	 * 深复制并且移动一个Node节点
	 * @param tran
	 * @param point
	 * @return
	 */
	public static Transform moveNodeToByCopy(Transform tran,Point3D point){
		Transform _tran = new Transform();
		try {
			_tran = (Transform)(tran.clone());
			_tran.setTranslation(new double[]{point.getX(),point.getY(),point.getZ()});
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return _tran;
	}

	/**
	 * 旋转普通节点
	 * @param node
	 * @param rotation
	 * @return
	 */
	public static Transform rotateNode(Node node,Rotation rotation){
		Transform tran = new Transform();
		tran.setChildren(new Node[]{node});
		tran.setRotation(new double[]{rotation.getX(),rotation.getY(),rotation.getZ(),VrmlUtils.getDegree(rotation.getDegree())});
		return tran;
	}
	
	/**
	 * 旋转Transform节点
	 * @param tran
	 * @param rotation
	 * @return
	 */
	public static Transform rotateNode(Transform tran,Rotation rotation){
		tran.setRotation(new double[]{rotation.getX(),rotation.getY(),rotation.getZ(),VrmlUtils.getDegree(rotation.getDegree())});
		return tran;
	}
}
