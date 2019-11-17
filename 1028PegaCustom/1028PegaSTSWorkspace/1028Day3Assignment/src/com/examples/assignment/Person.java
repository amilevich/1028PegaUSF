package com.examples.assignment;

public interface Person {

	default public void brain() {
		System.out.println("Person brain thinking...");
	}
}
