package com.assignments.day3;

public interface Person {
	//default keyword in interface
	int a = 200, b = 25, c = 50, d = 15, e = 10, f = 1;
	public void walk();
	public abstract void eat();
	
	default public void think() {
		System.out.println("concrete method with Java 8... Person thinking");
	}
}
