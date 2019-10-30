package com.example.polymorphism;

public class MainDriver {
	/*
	 * 
	 * polymorphism
	 * is the implementation of method overriding and mothod/constructor overloading
	 * 
	 * overloading occurs when two or more methods in one class have the same method name
	 * but different parameters
	 * 
	 * overriding means having two methods with the same name and parameters (i.e. the 
	 * same method signature) where one method is in the parent class and one is in the child class.
	 * you override the parent class's methood in the child class to provide a specific implementation.
	 * 
	 * overriding - runtime polymorphism
	 * overloading - compile time polymorphosm
	 * */
	
	public static void main(String[] args) {
		
		Parent p = new Parent();
		p.talk();
		
		Child c = new Child();
		c.talk();
		c.scold();
		
		Parent par = new GrndChild();
		par.talk();
		par.scold();
		
		
	}
}
