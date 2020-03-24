package com.example.polymorphism;

public class MainDriver {

	/*
	 * Polymorphism:
	 * The implementation of polymorphism in Java is method 
	 * overriding and method/constructor overloading
	 * 
	 * Overloading - occurs when two or more methods in one class
	 * have the same method name but different parameters
	 * 
	 *  Overriding - occurs when two methods with same name and 
	 *  parameters (i.e the same method signature) where 
	 *  one method is in the parent class an the other is in the
	 *  child class.
	 *  You override the parent classes method in the child class to 
	 *  provide a specific implementation 
	 *  
	 *  overriding is runtime polymorphism
	 *  overloading is compile time polymorphism
	 * 
	 */
	
	public static void main(String[] args) {
		
		Parent p = new Parent();
		p.talk();
		
		Child c = new Child();
		c.talk();
		

		Child g = new GrandChild();
		g.talk();
		g.scold(); //can still access since heirarchy
		
		Parent par = new GrandChild(); //this is more of an inheritance case -- will go over day four
		par.talk(); 
		par.scold();
		//par.jump(); // cannot access since of parent type
		
		GrandChild gc = new GrandChild();
		gc.talk();
		gc.jump();
	}
}
