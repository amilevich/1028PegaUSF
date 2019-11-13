package com.example.varargs;

public class MyClass {
	
	public static void main (String[] args) {
		fun();
		fun();
	}
	
	/*
	 * varargs - variable-length arguments
	 * A varargs method is a method that takes a variable # of args
	 */
	
	public static void fun(int ...a) {
		//this syntax tells the complier that fun() can be called with 0 or more arguments as a result
		// a is implicitly declared as an array of ints
		System.out.println("Number of arguments: " + a.length);
	}
	
	public static void fun2(String s, int ...a) {
		//takes in a single string and any number of ints
		System.out.println("String: " + s);
		System.out.println("Number of arguments: " + a.length);
	}
	
	//can only be one var arg in method and must be last arg
}
