package com.example.exception;

import java.io.IOException;

public class FinallyExample {

	public static void main(String[] args) {
		
		System.out.println(finallyReturn());
		try {
			throw new IOException();
		} catch(IOException ie) {
			System.out.println("in IO block");
		} catch (Error y) {
			System.out.println("in error block");
		} catch (Throwable ta) {
			System.out.println("in Throwable block");
		} finally {
			System.out.println("in Finally block");
		}
	}
	
	public static String finallyReturn() {
		
		try {
			throw new Exception();
		} catch(Exception e) {
			return "Here in catch";
		} finally {
			return "here in Finally";
		}
	}

}
