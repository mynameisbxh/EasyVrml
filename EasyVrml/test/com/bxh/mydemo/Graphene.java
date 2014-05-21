package com.bxh.mydemo;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Collections;

import org.junit.Test;

import com.bxh.easyvrml.document.DocumentManager;
import com.bxh.easyvrml.document.VDocument;
import com.bxh.easyvrml.element.field.Point3D;
import com.bxh.easyvrml.generator.TransformGenerator;
import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.basic.Appearance;
import com.bxh.easyvrml.node.basic.Box;
import com.bxh.easyvrml.node.basic.Cone;
import com.bxh.easyvrml.node.basic.Group;
import com.bxh.easyvrml.node.basic.Material;
import com.bxh.easyvrml.node.basic.Shape;
import com.bxh.easyvrml.node.basic.Sphere;
import com.bxh.easyvrml.node.basic.Transform;
import com.bxh.easyvrml.node.extend.Define;
import com.bxh.easyvrml.node.extend.Edge;
import com.bxh.easyvrml.node.extend.Label;
import com.bxh.easyvrml.node.extend.Rotation;
import com.bxh.easyvrml.tools.ColorConfig;
import com.bxh.easyvrml.tools.Matrix;
import com.bxh.easyvrml.tools.ViewpointConfig;
import com.bxh.easyvrml.tools.VrmlUtils;

public class Graphene {

	private DocumentManager manager;
	
	@Test
	public void test(){
		manager = new DocumentManager();
		VDocument doc = new VDocument();
		
		double _len = 0;										//距离原点的z轴的长度
		double _ra = 3;											//圆环的半径
		double _deg = 30;										//每次迭代的角度
	
		Point3D points[] = getGraphenePoints(_ra, _deg);		//获取一个环的所有点的坐标
		
		_len =_ra* VrmlUtils.getDegree(_deg)/Math.sqrt(3);		//计算出正六角形的高
		
		Transform trans[] = new Transform[points.length];
		for(int i = 0 ;i<points.length;i++){
			trans[i] = TransformGenerator.moveNodeTo(new Shape(new Appearance(new Material(ColorConfig.SOFT_COLOR_RED)),new Sphere(0.3)), points[i]);
			doc.addNode(trans[i]);
			doc.addLabelForNode(trans[i], new Label(i+"",0.3));
		}
		
		doc.addNode(Define.addDefine( new Group(trans), "g"));	//定义组节点
		
		double _loc = 0;
		Point3D _p0[] = new Point3D[points.length];
		Point3D _p1[] = new Point3D[points.length];
		
		for(int i =0 ;i<points.length;i++){
			_p0[i] = new Point3D(points[i].getX(),points[i].getY(),points[i].getZ());
			_p1[i] = new Point3D();
		}
		
		boolean is0 = true;
		boolean is1 = false;
		Point3D _pp = _p0[0];
		
		for(int i = 1 ;i<=35;i++){
			if((i-1)%4/2==0){
				if(i%2==1){
					_loc+=(_len/2);
					is0 = true;
				}else{
					_loc+=_len;
					is0 = false;
				}
				_pp = new Point3D(_p0[0].getX(),_p0[0].getY(),_p0[0].getZ());
				for(int _ii = 0;_ii<_p0.length;_ii++){
					Point3D _p = TransformGenerator.getRotatedLocation(new Point3D(_ra,0,-_loc), new Rotation(0,0,1,(_ii)*30 + 15));
					_p1[_ii].setX(_p.getX());
					_p1[_ii].setY(_p.getY());
					_p1[_ii].setZ(-_loc);
					doc.addEdgeByPoints(new Edge(_p0[_ii],_p1[_ii]));
					if(is0&&_ii>=1){
						doc.addEdgeByPoints(new Edge(_p0[_ii],_p1[_ii-1]));
					}
					_p0[_ii].setX(_p1[_ii].getX());
					_p0[_ii].setY(_p1[_ii].getY());
					_p0[_ii].setZ(_p1[_ii].getZ());
				}
				if(is0){
					doc.addEdgeByPoints(new Edge(_pp,_p1[_p1.length-1]));
				}
				doc.addNode(TransformGenerator.rotateNode(TransformGenerator.moveNodeTo(Define.getNodeByName("g"), new Point3D(0,0,-_loc)), new Rotation(0,0,1,VrmlUtils.getDegree(15))));
			}else{
				if(i%2==1){
					is1 = true;
					_loc+=(_len/2);
				}else{
					is1 = false;
					_loc+=_len;
				}
				for(int _ii = 0;_ii<_p0.length;_ii++){
					_p1[_ii].setX(points[_ii].getX());
					_p1[_ii].setY(points[_ii].getY());
					_p1[_ii].setZ(-_loc);
					doc.addEdgeByPoints(new Edge(_p0[_ii],_p1[_ii]));
					if(is1&&_ii>=1){
						doc.addEdgeByPoints(new Edge(_p0[_ii-1],_p1[_ii]));
					}
				}
				if(is1){
					doc.addEdgeByPoints(new Edge(_p0[_p0.length-1],_p1[0]));
				}
				for(int k = 0;k<_p0.length;k++){
					_p0[k].setX(_p1[k].getX());
					_p0[k].setY(_p1[k].getY());
					_p0[k].setZ(_p1[k].getZ());
				}
				doc.addNode(TransformGenerator.moveNodeTo(Define.getNodeByName("g"), new Point3D(0,0,-_loc)));
			}
		}
		doc.addViewpoint(ViewpointConfig.V_FRONT);
		doc.addViewpoint(ViewpointConfig.V_BACK);
		doc.addViewpoint(ViewpointConfig.V_LEFT);
		doc.addViewpoint(ViewpointConfig.V_RIGHT);
		doc.addViewpoint(ViewpointConfig.V_UP);
		doc.addViewpoint(ViewpointConfig.V_DOWN);
		
		manager.write(doc, "Graphene.wrl");
	}
	
	public Point3D[] getGraphenePoints(double radius,double degree){
		Point3D points[] = new Point3D[(int)(360/degree)];
		double _d = 0;
		for(int i = 0;i<points.length;i++){
			points[i] = new Point3D(radius*Math.cos(VrmlUtils.getDegree(_d)),radius*Math.sin(VrmlUtils.getDegree(_d)),0);
			_d+=degree;
		}
		return points;
	}
}
