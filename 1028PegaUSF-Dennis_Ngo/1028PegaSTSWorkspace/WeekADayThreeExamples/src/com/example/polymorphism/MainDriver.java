package com.example.polymorphism;

public class MainDriver {
	/*
	 * Polymorphism
	 * 
	 * In Java is method overriding and method overloading
	 * 
	 * Overloading occurs when two or more methods in one class have same name but different parameters
	 * Overriding means having two methods with same name and parameters (same method signature)
	 * where one is in parent and the other in child class.
	 * 
	 * You override the parent class's method in the child class for specific implementation
	 * 
	 * Overriding - runtime polymorphism
	 * Overloading - compile time polymorphism
	 * 
	 */
	
	public static void main(String[] args) {
		
		Parent p = new Parent();
		//p.talk();
		
		Child c = new Child();
		//c.talk();
		c.scold();
		
		Parent par = new GrandChild();
		par.talk();
		par.scold();
		
		
	}
}
