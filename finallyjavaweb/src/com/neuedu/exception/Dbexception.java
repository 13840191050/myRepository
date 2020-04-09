package com.neuedu.exception;

public class Dbexception extends Exception {
	 private int code;

	public Dbexception(String message,int code) {
		super(message);
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	 
}
