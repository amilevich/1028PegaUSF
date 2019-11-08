package com.assignment2.interfaces;

public interface Animal {
	
	default public void sleep() {
		System.out.println("Sleep method from animal interface");
	}
}
