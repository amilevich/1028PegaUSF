package com.exampke.exceptions;

import java.io.IOException;

public class FinallyExample {

	public static void main(String[] args) {

		try {
			throw new IOException();
		} catch (IOException e) {
			System.out.println("In IO block");
		} catch (Error y) {
			System.out.println("In Error block");
		} catch (Throwable t) {
			System.out.println("In Throwable block");
		} finally {
			System.out.println("in finally block");
		}
		System.out.println("Done!");
		
		System.out.println(finallyReturn());
	}
	
	@SuppressWarnings("finally")
	public static String finallyReturn() {
		
		try {
			throw new Exception();
		} catch(Exception e) {
			return "Here in catch";
		} finally {
			return "here in finally"; //will run this one because always will do finally -- added a suppress  
		}
	//	return "Outside of catch"; //will give you error because returns already in catch block
	}

}
