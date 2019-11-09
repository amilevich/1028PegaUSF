package com.example.polymorphism;

public class MainDriver {
	/*
	 * Polymorphism
	 *  
	 *  The implementation of polymorphism in java is the method overriding
	 *  and method/constructor overloading
	 *  
	 *  Overloading -> occurs when two or more methods in one class have the same
	 *  method name but different parameters
	 *  
	 *  Overriding -> means having two methods with the same name and parameters
	 *  (i.e. the same method signature) where one method is in the parent class and one is in the child class.
	 *  
	 *  You override the parent class's method in the child class to provide a specific implementation.
	 *  
	 *  Overriding is runtime polymorphism
	 *  Overloading is compile time polymorphism
	 *  
	 */

	public static void main(String[] args) {
		
		Parent p = new Parent();
		p.talk();
		
		Child c = new Child();
		c.talk();
		
		Parent par = new GrandChild();
		par.talk();
		par.scold();
	}
}
