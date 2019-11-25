package com.example.interfaces;

public interface Person {

	int a = 4; //implicit public static final
	public static final int b = 8;
	
	public void walk();
	default public void think() {
		System.out.println("Print from Person interface....");
	}
}