package com.example.interfaces;

public interface Animal {

	default public void think() {
		System.out.println("concrete method with java 8... thinking- In Animal interface");
	}
	
	public void sound();
	
}
