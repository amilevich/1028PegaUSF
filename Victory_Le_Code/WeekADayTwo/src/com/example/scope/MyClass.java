package com.example.scope;

public class MyClass {
	/*
	 * What are Scopes?
	 * the lifetime of a variable
	 * 
	 * 4 scopes:
	 * 
	 * Class/Static - variables exist for the lifetime of the class and exist within the class itself.
	 * 
	 * Object/Instance - the object's field/state variables exist for the lifetime of the object and exist within the object itself.
	 * 
	 * Local/Method - parameters and any variables defined at the method level. Variables exist for the lifetime of the method call. 
	 * 
	 * Block/Loop - any variables within the curly braces or a control flow statement 
	 */
	
	public static int i; // class/static scope
	/*
	 * static keyword when used with a variable makes this variable belong to the class. There is only one copy of this variable for the entire class. You can access this variable's value from within any scope in this class
	 */
	
	static {
		int i = 5; //block scope
	}
	
	public static void main(String[] args) {
		int k = 7; //method scope
		for (int j=0; j<3; j++) {
			int m= 10; //block scope
		}
		
		MacAndCheese mc = new MacAndCheese(true, "shell", 3);
		// typeofNoodles -> object type
	}
}


public class MacAndCheese{
	boolean isDelicious; //class scope
	String typeOfNoodles;
	int numOfCheese;
	public MacAndCheese(boolean isDelicious, String typeOfNoodles, int numOfCheese) {
		super();
		this.isDelicious = isDelicious;
		this.typeOfNoodles = typeOfNoodles;
		this.numOfCheese = numOfCheese;
	}
	
	
}