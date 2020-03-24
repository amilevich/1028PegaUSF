package com.exampke.exceptions;

public class ExceptionExample {
	/*
	 * If the JKVM ever sees an Exception , the program will terminate
	 * 
	 *  Check v unchecked
	 *  	Checked: Exceptions need to have a try/catch OR they need to be "ducked"
	 *  			else, you will get a syntax (compile) error
	 *  	Unchecked: Exceptions can have a try/catch OR can be "ducked" (throw) 
	 *  				BUT, it is not forced to. No sysntax errors.
	 *  
	 */

	public static void main(String[] args) throws Exception {

		/*
		 * Purposefully throwing exeption to see exceptions
		 * 
		 * can make own custom exception using "throw" keyword
		 */

		// throw new Exception();
		// throw new RuntimeException();

		// Object obj = new Object();
		// Throwable th = new Throwable();
		// // throw obj; //No exception of type Object can be thrown; an exception type
		// // must be a subclass of Throwable
		
		/*
		 * The try block is wrapped around risky behavior that COULD possibly
		 * throw and exception 
		 * 
		 * 
		 * Catch block is like an IF statement that has a true condition
		 * when the specific condition in question is thrown
		 */
		
		// // throw th; //changed throws Exception to throws Throwable
		// try { //try with resources with IO stream
		// throw th;
		// } catch (Throwable e) {
		// e.printStackTrace(); //takes a snapshot upon creation -- exception says its
		// at line 17
		// System.out.println("In catch block");
		// }
		// System.out.println("Outside of catch block");

		ExceptionExampleHelper.triggerException(); // print stack trace shows where error in maindriver and in class
													// (object) called
		ExceptionExampleHelper.howToDuck(); // Exception in thread "main" java.lang.RuntimeException because was thrown
											// back to main

	}

}
