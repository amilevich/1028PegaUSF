package com.example.varargs;

public class MyClass {
	
	/*
	 * Varargs - variable-length arguments
	 * A varargs method is a method that takes a variable
	 * number of arguments
	 */
	public static void main(String[] args) {
//		fun();
//		fun(1,2,3,100,856,4);
//		fun(200);
		
		fun2("Hello", 7);
		fun2("Bye");
		fun2("Mac n' Cheese", 4, 5, 200, 400);
	}
	
	public static void fun(int ...a) {
		//this syntax tells the compiler that fun() can be
		//called with 0 or more arguments
		//as a result, a is implicitly declared as an array of ints
		System.out.println("Number of arguments: " + a.length);
	}
	
	public static void fun2(String s, int ...a) {
		//takes in a single string and any number of ints
		System.out.println("String: " + s);
		System.out.println("Number of arguments: " + a.length);
	}
	//there can only be one variable argument in a method and
	//it must be the last argument

}