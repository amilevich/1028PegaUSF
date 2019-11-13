package com.exampke.exceptions;

public class ExceptionExampleHelper {

	public static void howToDuck() throws Exception {
		throw new RuntimeException();
	}
	
	public static void triggerException() {
		Throwable th = new Throwable();
		RuntimeException re = new RuntimeException();

		try {
			// throw th; //comment out re tp see throwable catch 
			throw re; //comment out th to see runtime exception catch
		} catch (RuntimeException e) { // most specific to most general
			System.out.println("caught by Runtime exception");//says it in print trace already left aligned
			re.printStackTrace();
		} catch (Throwable e) {
			System.out.println("caught by Throwable");//says it in print trace already left aligned
			e.printStackTrace();
		}
	}
}
