package com.example.exceptions;

import java.io.IOException;

public class FinallyExample {

	public static void main(String[] args) {

		try {
			throw new IOException();
		}catch(IOException ie) {
			System.out.println("in IO block");
		}catch(Error y) {
			System.out.println("in Error block");
		}catch(Throwable th) {
			System.out.println("in throwable block");
		}finally {
			System.out.println("in finally");
		}
		
		System.out.println("done");
		
		System.out.println(finallyReturn());
	}
	
	@SuppressWarnings("finally")
	public static String finallyReturn() {
		try {
			throw new Exception();
		}catch(Exception e) {
			return"here in a catch";
		}finally {
			return"here in finally";
		}
	}

}
