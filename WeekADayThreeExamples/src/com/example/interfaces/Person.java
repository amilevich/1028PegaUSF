package com.example.interfaces;

public interface Person {
	
	int a = 4;// all variables are public static and final even if you do  not specify it
	//implicitly this is always public static final
	
	public static final int b = 8;
	
	public void walk();// methods in interfaces do no need to have {}
	
	default public void think() {
		System.out.println("concrete method with java 8..... thinking");
	}

}
