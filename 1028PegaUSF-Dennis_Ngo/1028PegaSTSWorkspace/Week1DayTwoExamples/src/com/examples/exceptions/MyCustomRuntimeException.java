package com.examples.exceptions;

public class MyCustomRuntimeException extends Exception {
	
	public MyCustomRuntimeException() {
	
	}
	
	public MyCustomRuntimeException(String message) {
		super(message);
	}
	public MyCustomRuntimeException(String message, Throwable clause) {
		super(message, clause);
	}
}
