package com.example.exception;

public class ExceptionExampleHelper {

	
	
	public static void howToDuck() throws Exception{
		throw new RuntimeException();
	}
	
	
	public static void triggerException() {
		Throwable th = new Throwable();

		throw th;
		throw obj;
		try {
			/*
			 *  the try block is wrapped around risky behavior that could possibly throw an exception
			 */
			throw th;
		} 
		
		RuntimeException re = new RuntimeException();
		
		
		try {
			throw re;
		}catch(RuntimeException re2) {
			re2.printStackTrace();
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}
}
