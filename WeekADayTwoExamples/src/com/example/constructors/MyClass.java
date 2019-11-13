package com.example.constructors;

public class MyClass {
	/*
	 * what is a constructor?
	 * is a block of code that instantiates a newly created object
	 * 
	 * NOT a method because it doesn't have a return type and cannot be
	 * overridden.
	 * cannot be abstract, final or static
	 * must be named as the name of the class it belongs to
	 */
	
	MyClass(){
		System.out.println("in constructor");
	}
	
	/*
	 * There are 3 types of constructors:
	 * default - if no constructor is explicitly provided, the JVM 
	 * provides you with a no-argument constructor by default
	 * no-arg - constructor with no arguments/parameters. The signature
	 * of this no-arg constructor is the same as the default one but the
	 * body can have any code unlike the default constructors
	 * parameterized - constuctor with arguments or parameters
	 */
	
	public static void main(String[] args) {
		
		Tiger tiger1 = new Tiger("Tony", 3);
		Tiger tiger2 = new Tiger(true, 6, 4, "John");
		
		//System.out.println(tiger1.getName() + tiger1.getNumberOfLegs() + tiger1.getStripes());
		System.out.println(tiger2);
		//tiger2.info();
	}

}
