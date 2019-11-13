package com.example.constructors;

public class MyClass {
	/*
	 * Constructor is a block of code that instantiates a new created obj
	 * 
	 * NOT a mthod because it doesn't have a reurn type and cannot be overidden
	 * cant be abstract, final or static
	 * must e same name as class it belongs too
	 */
	
	MyClass(){
		
		/*3 types of constructors:
		 * default - if no constructor is explicitly provided, the JVM provides you a no-arg constructor by default
		 * no-arg - constructor with no arg / parameters. Signature is same as default but body can have any code
		 * parameterized - constructo with args or parameters
		 */
		
		public static void main(String[] args) {
			Tiger tiger1 = new Tiger("Tony", 3);
			Tiger tiger2 = new Tiger(true, 6, 4, "John");
			
			System.out.println(tiger1.getName() + tiger1.getNumberOfLegs() + tiger1.getStripes());
			
		}
		
	}
}
