package com.example.interfaces;

 public interface Person {

	int a = 4;
	//implicitly this is always public static final
	
	public static final int b = 8; // best practice to write this out like this
	
	public void walk(); //can put public abstract void walk(); which is same thing --> implicitly abstrat in interfaces
	
	default public void think() {
		System.out.println("concrete method with java 8... thinking - Person interface");
	}
}
