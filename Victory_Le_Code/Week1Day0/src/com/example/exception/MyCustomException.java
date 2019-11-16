package com.example.exception;

public class MyCustomException extends Exception {
	public MyCustomException() {
	}
	
	public MyCustomException(String message) {
		super(message);
	}
	
	public MyCustomException(String message, Throwable clause) {
		super(message,clause);
	}
}
