package com.example.varargs;

public class MyClass {

	/*
	 * VarArgs: Variable-length Arguments
	 * A varargs methods is a method that takes a variable 
	 * number of arguments
	 */
	
	public static void fun(int ...a) { //..a is the syntax to creating variable-length arguments
		//the "..." means will take in 0 or more integer variables
		//as a result a is implicitly declared as an array of integers
		System.out.println("Number of arguments: " + a.length);
	}
	
	public static void fun2(String s, int ...a) { // the vararg has to be at the end, can only have one vararg 
		//will take in a single string and any number of integers after
		System.out.println("String: " + s);
		System.out.println("Number of arguments: " + a.length);
	}
	
	public static void main(String[] args) {
		fun();
		fun(1, 2, 3, 100, 856, 4);
		fun(1);
		
		fun2("Hello", 10, 90, 14);
		fun2("Bye");
		fun2("Eat", 7);
	}
}
