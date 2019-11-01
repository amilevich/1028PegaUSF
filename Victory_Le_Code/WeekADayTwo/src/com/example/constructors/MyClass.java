package com.example.constructors;

public class MyClass {
	/*
	 * What is a constructor?
	 * 
	 * A block of code that instantiates a newly created object.
	 * 
	 * NOT A METHOD because it does not have a return type and cannot be overridden. 
	 * cannot be abstract, final or static.
	 * MUST be named as the name of the class it belongs to
	 */
	
	MyClass(){
		/*
		 * There are 3 types of constructors:
		 * default - if no constructor is explicitly provided, the JVM provides you with a no-argument constructor by default
		 * no-arg - constructor with no arguments/parameters. The signature of this no-arg constructor is the same as the default one but the body can have any code unlike the default constructors.
		 *parameterized - constructor with arguments or parameter
		 */
		
		public static void main (String[] args) {
			
			Tiger tiger = new Tiger("Tony", 3);
			Tiger tiger2 = new Tiger(true, 6, 4, "John");
		}
	}

	@Override
	public String toString() {
//		String info = "Does tiger have an eye?" + hasEye + "and the name is "+name+ = and number of legs+ + numberOfLegs" + and number of stripes is stripes.
		return;
	}
	
	public void info() {
		System.out.println("Tiger's name is ") + name =and "");
	}
}
