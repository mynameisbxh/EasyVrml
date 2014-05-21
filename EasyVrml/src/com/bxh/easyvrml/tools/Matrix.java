package com.bxh.easyvrml.tools;

public class Matrix {

	private double values[][];

	public Matrix(int row,int col) {
		this.values = new double[row][col];
	}
	
	public Matrix(Matrix matrix) {
		this.values = matrix.getValues();
	}

	public Matrix multipMatrix(Matrix m){
		Matrix _m = new Matrix(this.values.length,m.getValues()[0].length);
		double _v[][] = _m.getValues();
		double _mv[][] = m.getValues();
		double _t = 0;
		for(int i =0 ;i<this.values.length;i++){
			for(int j = 0;j<_mv[0].length;j++){
				for(int k = 0;k<_mv.length;k++){
					_t+=this.values[i][k]*_mv[k][j];
				}
				_v[i][j] = _t;
				_t = 0;
			}
		}
		_m.setValues(_v);
		return _m;
	}
	
	public double[][] getValues() {
		return values;
	}

	public void setValues(double[][] values) {
		this.values = values;
	}
	
}
