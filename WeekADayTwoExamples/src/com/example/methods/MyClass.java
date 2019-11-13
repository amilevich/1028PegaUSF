package com.example.methods;

public class MyClass {

	public static void main(String[] args) {
		MyClass obj = new MyClass();
		obj.methodOne();
		methodTwo();
		methodThree("Hello", "World");
	}
	
	public void methodOne() {
		System.out.println("methodOne() called");
	}
	
	public static void methodTwo() {
		System.out.println("static methodTwo() called");
	}
	
	public static void methodThree(String s, String t) {
		System.out.println("methodThree(String s, String t) called with arguments"
				+ " " + s + " " + t);
		
	}
}
