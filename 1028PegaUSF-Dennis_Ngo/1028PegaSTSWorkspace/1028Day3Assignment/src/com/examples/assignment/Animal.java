package com.examples.assignment;

public interface Animal {

	default public void brain() {
		System.out.println("Animal brain is thinking...");
	}
}
