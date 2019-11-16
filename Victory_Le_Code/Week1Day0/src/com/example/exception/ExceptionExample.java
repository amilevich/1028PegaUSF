package com.example.exception;

public class ExceptionExample {

	/*
	 * If Jvm ever sees an exception the program will terminate
	 * 
	 * Check vs Uncheck 
	 * 		Checked exceptions need to have a try/catch OR they need to be ducked.
	 * 			Else you will get a compile/syntax error.
	 * 		Unchecked exceptions can have a try/catch OR can be ducked, BUT you are not forced to. No Syntax Error 
	 */
	public static void main(String[] args) throws Exception{
	
		
		ExceptionExampleHelper.triggerException();
		ExceptionExampleHelper.howToDuck();
	}

}
