package com.example.exceptions;

public class MyCustomRuntimeException {
	public MyCustomRuntimeException() {
		// TODO Auto-generated constructor stub
	}
	
	public MyCustomRuntimeException(String message) {
		super(message);
	}
	
	public MyCustomRuntimeException(String message,Throwable clause) {
		super(message,clause);
	}

}
