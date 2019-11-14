package com.example.exceptions;

import java.io.IOException;

public class ExceptionsExample {
	
	/*
	 * if JVM ever sees an exception the program will terminate
	 * 
	 * Check vs Uncheck
	 * 		Checked expections need to have a try/catch OR they need to be ducked.
	 * 			Else you will get an syntax error.
	 * 		Unchecked exceptions can have a try/catch OR can be ducked, BUt you are not
	 * 			forced to. No syntax errors.
	 */

	public static void main(String[] args) throws Exception {
//		throw new Exception();
//		throw new RuntimeException();
		
		
		Throwable th = new Throwable();
		
//		throw obj;
//		try {
		/*
		 * the try block is wrapped around risky behavior that COULD possibly throw an
		 * exception
		 */
//			throw th;
//		}catch (Exception e2) {
		/*
		 * the catch block is like an If statement that has a true condition when the 
		 * specific exception in question is thrown.
		 */
//			
//		}catch(Throwable e) {
//			e.printStackTrace();
//			System.out.println("In catch block");
//		}
//		System.out.println("Outside catch");
		
		ExceptionExampleHelper.triggerException();
		ExceptionExampleHelper.howToDuck();
	
	}

}
