package com.example.abstractclass;

public abstract class Person {
	
	public static final int a =2;
	
	protected int b = 23;
	
	public Person() {
		System.out.println("in person constructor");
	}
	
	public void sleep() {
		System.out.println("what is sleep? dont hurt me, no more");
	}
	
	public abstract void eat();
	
}
