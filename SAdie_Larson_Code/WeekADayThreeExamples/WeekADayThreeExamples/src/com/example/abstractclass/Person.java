package com.example.abstractclass;

 abstract class Person {

	public static final int a = 2;
	
	protected int b = 23;
	
	public Person() {
		System.out.println("Inside Person Constructor");
	}
	
	public void sleep() {
		System.out.println("What is sleep?");
	}
	
	public abstract void eat();
	
}
