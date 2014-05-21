package com.bxh.easyvrml.node.extend;

import com.bxh.easyvrml.element.field.Point3D;
import com.bxh.easyvrml.impl.Node;
import com.bxh.easyvrml.node.basic.Transform;
import com.bxh.easyvrml.tools.VrmlUtils;

/**
 * Edge 表示节点之间的边，有两个参数（_start和_end），_start表示起始点，_end表示终止点
 * 
 * @author BXH
 */
public class Edge {

	private Transform start;		//起始点
	private Transform end;			//终止点
	
	private Point3D _start;
	
	private Point3D _end;
	
	/**
	 * Eage 的构造函数
	 * @param _start	起始点节点
	 * @param _end	终止点节点
	 */
	public Edge(Transform start,Transform end){
		this.start = start;
		this.end   = end;
	}
	
	public Edge(Point3D start,Point3D end){
		this._start = start;
		this._end   = end;
	}
	
	public Point3D getStartPoint(){
		return VrmlUtils.getLocationOfTransform(start);
	}
	
	public Point3D getEndPoint(){
		return VrmlUtils.getLocationOfTransform(end);
	}
	
	public Transform getStart() {
		return start;
	}

	public void setStart(Transform start) {
		this.start = start;
	}

	public Transform getEnd() {
		return end;
	}

	public void setEnd(Transform end) {
		this.end = end;
	}

	public Point3D get_start() {
		return _start;
	}

	public void set_start(Point3D _start) {
		this._start = _start;
	}

	public Point3D get_end() {
		return _end;
	}

	public void set_end(Point3D _end) {
		this._end = _end;
	}
}
