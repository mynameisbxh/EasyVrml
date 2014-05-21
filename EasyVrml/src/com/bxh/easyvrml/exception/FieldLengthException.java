package com.bxh.easyvrml.exception;


public class FieldLengthException extends IllegalArgumentException{
	private static final long serialVersionUID = 1L;

	public FieldLengthException(){}

	public FieldLengthException(String s){
		super(s);
	}
}
