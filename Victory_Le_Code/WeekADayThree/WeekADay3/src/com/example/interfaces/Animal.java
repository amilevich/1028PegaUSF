package com.example.interfaces;

public interface Animal {
	
	default public void think() {
		System.out.println("Thinking like an animal");
	}

}
