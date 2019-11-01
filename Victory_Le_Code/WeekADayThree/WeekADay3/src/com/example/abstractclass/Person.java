package com.example.abstractclass;

public abstract class Person {

	
	public static final int a = 2;
	
	protected int b = 23;
	
	public Person() {
		super();//implicit applied to go to parent object
		System.out.println("******in Person Constructor********");

	}
	
	public void sleep() {
		System.out.println("what is sleep, baby dont hurt me, don't hurt me, no more");
	}
	
	public abstract void eat();
	

}
