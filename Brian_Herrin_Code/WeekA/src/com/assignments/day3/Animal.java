package com.assignments.day3;

public interface Animal {
	default public void think() {
		System.out.println("concrete method with Java 8... Animal thinking");
	}
}
