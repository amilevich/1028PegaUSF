package com.assignment2.interfaces;

public interface Person {
	
	default public void sleep() {
		System.out.println("Sleep method from person interface");
	}
}
