package com.example.constructors;

public class MyClass {

	/*
	 * Constructor: 
	 * a block of code that instantiates a newly created object
	 * 
	 * NOT methods because constructors do not have a return type and 
	 * they cannot be overridden
	 * cannot be abstract, final, or static
	 * must be named as the name of the class it belongs to
	 * 
	 */
	
	//MyClass(){} //very very simple constructor (default)
	
	MyClass(){
		System.out.println("no argument constructor"); //no argument constructor
	}
	
	/*
	 * There are 3 types of constructors
	 * 
	 * 1. default -> if no constructor is explicitly provided the JVM provides
	 * you with a no-argument constructor by default
	 * 
	 * 2. no-argument constructor -> constructor with no arguments/parameters. The 
	 * signature of this no-arg constructor is the same as the default one but the 
	 * body can have any code unlike the default constructor
	 * 
	 * 3.parameterized - constructor with arguments or parameters
	 */
	
	public static void main(String[] args) {
	
		Tiger tiger1 = new Tiger("Tony", 3);
		Tiger tiger2 = new Tiger(true, 6, 4, "John");
		
		System.out.println(tiger1.getName() + "  has " + tiger1.getNumberOfLegs() + " legs");
		
		System.out.println(tiger2); //quicker than having to call .get method for every parameter
		//if just used tiger 1 then default of the hasEye is false since not declared
		
		tiger1.info();
		
		
	}
}
