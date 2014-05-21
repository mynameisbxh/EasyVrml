package com.bxh.easyvrml.node.extend;

public class Rotation {
	private double x;
	private double y;
	private double z;
	private double degree;
	
	public Rotation() {
		this(0,0,0,0);
	}
	
	public Rotation(double x, double y, double z, double degree) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.degree = degree;
	}
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}
	public double getDegree() {
		return degree;
	}
	public void setDegree(double degree) {
		this.degree = degree;
	}
}
