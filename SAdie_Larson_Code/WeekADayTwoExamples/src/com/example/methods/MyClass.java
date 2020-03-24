package com.example.methods;

public class MyClass {

	public static void main(String[] args) {

		MyClass object = new MyClass();
		object.methodOne();

		methodTwo(); // anything italicized is a static method
		// can do this because we are in the same class that the method is defined
		// yesterday had to call class.method();
		
		methodThree("Hello", "World");

	}

	public void methodOne() {
		System.out.println("MethodOne() called");
	}

	public static void methodTwo() {
		System.out.println("Static methodTwo() called");
	}

	public static void methodThree(String s, String t) {
		System.out.println("MethodThree(String s, String t) called with arguments " + s + " " + t);
	}
}
