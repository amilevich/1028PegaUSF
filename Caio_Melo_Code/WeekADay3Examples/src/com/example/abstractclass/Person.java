package com.example.abstractclass;

public abstract class Person {

	public static final int a = 2;
	
	protected int b = 23;
	
	public Person() {
		System.out.println("In person constructor");
	}
	
	public void sleep() {
		System.out.println("zzzz.....");
	}
	
	public abstract void eat(); 
	//if it has an abstract method, it is an abstract class.
		
}
