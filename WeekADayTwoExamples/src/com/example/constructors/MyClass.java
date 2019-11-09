package com.example.constructors;

import com.example.methods.Tiger;

public class MyClass {
	
	/*
	 * Constructor is a block of codes that instantiates a newly created object
	 * 
	 * NOT methods because constructors do not have a return type and cannnot be overriden
	 * cannot be abstract, final or static
	 * MUST be named as the name of the class it belongs to
	 */
	
	MyClass(){}
	/*
	 * types of constructors
	 * 
	 * 1) default -> if no constructor is explicitly provided, the JVM provides you with a no-argument 
	 * constructor by default
	 * 
	 * 2)no-argument -> is a constructor with no-argument or parameters. The signature of this no-arg
	 * constructor is the same as the default one but the body can have any code unlike the default constructor
	 * 
	 * 3) parameterized -> constructor with arguments or parameters
	 */
	
	public static void main(String[] args) {
		
		Tiger tiger1 = new Tiger("Tony", 3);
		Tiger tiger2 = new Tiger(true,6,4,"john");
		System.out.println(tiger2);
	}

}
