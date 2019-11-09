package com.example.abstractclass;

public abstract class Person {
	
	public static final int a =2;
	
	protected int b = 23;
	
	public Person() {
		// ctrl/space/enter Auto-generated constructor stub
		
		System.out.println("in person constructor");
		
		
	}
	
	
	
	public void sleep() {
		
		System.out.println("what is sleep? baby don't hurt me, don't hurt me no more");
	}
	
	public abstract void eat();// because of the abstract keyword we do not need {}
	
	

}
