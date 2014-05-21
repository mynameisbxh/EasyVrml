package com.bxh.easyvrml.node.basic;

import com.bxh.easyvrml.impl.Node;

public class Normal implements Node {
	
	private double[] vector;			//Ê¸Á¿×ø±ê

	public Normal() {
		vector = new double[0];
	}

	public Normal(double[] vector) {
		this.vector = vector;
	}

	public double[] getVector() {
		return vector;
	}

	public void setVector(double[] vector) {
		this.vector = vector;
	}
}
