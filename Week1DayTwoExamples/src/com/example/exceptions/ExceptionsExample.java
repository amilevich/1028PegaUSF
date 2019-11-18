package com.example.exceptions;

public class ExceptionsExample {
	
	/*
	 * If JVM ever sees an exception,  the program will terminate
	 * 
	 * Check vs Unchecked
	 * 
	 * Check:  exceptions need to have a try/catch or they need to be ducked.
	 * else you will get an syntax error.
	 * 
	 * Unchecked: exceptions can have a try/catch or can be ducked, but you are not forced to.
	 * No syntax errors.
	 * 
	 * Try: the block is wrapped around risky behavior that could possibly throw an exception.
	 * 
	 * Catch: 
	 * Throw: 
	 * 
	 * 
	 */

	public static void main(String[] args) throws Throwable {
		
		//throw new Exception();
		//throw new RuntimeException();
		
//		Object obj = new Object();
//		Throwable th = new Throwable();
//		//throw obj;
//		try {
//			throw th;
//		}catch(Throwable e){
//			e.printStackTrace();
//			System.out.println("In the catch block");
//			
//		}
//		System.out.println("Outside catch");
		
		Throwable th = new Throwable();
		//throw th;
		ExceptionExampleHelper.triggerException();
		
		ExceptionExampleHelper.howToDuck();

	}

}
