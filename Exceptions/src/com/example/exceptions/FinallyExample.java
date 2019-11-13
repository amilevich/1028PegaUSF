package com.example.exceptions;

import java.io.IOException;

public class FinallyExample {
	
	@SuppressWarnings("finally")
	public static String finallyReturn() {
		
		try {
			throw new Exception();
		}catch(Exception e) {
			return "Here in Catch";
		}finally {
			return "Here in Finally";
		}
	}

	public static void main(String[] args) {
		
		System.out.println(finallyReturn());
		
		try {
			throw new IOException();
		}catch(IOException ie) {
			System.out.println("in IO block");
		}catch (Error y) {
			System.out.println("in error Block");
		}catch (Throwable th) {
			System.out.println("in Throwable block");
		}finally {
			System.out.println("in finally block");
		}
		
		System.out.println("Done!");

	}

}
