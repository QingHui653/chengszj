package com.hengshuo.chengszj.exception;

public class Myexception extends Exception {
	private String message;
public String getMessage() {
	return message;
}
	public void setMessage(String message) {
		this.message = message;
	}
	public Myexception(String message) {
		super(message);
		this.message=message;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Myexception [message=" + message + "]";
	}
	
}
