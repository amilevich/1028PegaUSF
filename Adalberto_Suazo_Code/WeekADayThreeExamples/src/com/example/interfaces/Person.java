package com.example.interfaces;

public interface Person {
	
	int a = 4; //implicitly this is always public static final
	
	public static final int b = 8;
	
	public void walk(); //method
	
	default public void think() {
		System.out.println("concrete method with java 8...thinking");
	}
}
