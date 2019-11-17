package com.example.abstractclass;

public abstract class Person {
	public static final int a = 2;
	
	protected int b = 23;
	
	public Person() {
		System.out.println("**In person constructor**");
	}
	
	public void sleep() {
		System.out.println("What is sleep?" + " Baby don't hurt me.");
	}
	
	public abstract void eat();
}
