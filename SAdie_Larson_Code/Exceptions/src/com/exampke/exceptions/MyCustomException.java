package com.exampke.exceptions;

public class MyCustomException extends Exception {

	public MyCustomException() {

	}

	public MyCustomException(String message) {
		super(message);// calls exception class and sends in message
	}

	public MyCustomException(String message, Throwable clause) { // nested exception that triggers another exception
		super(message, clause);
	}

}
