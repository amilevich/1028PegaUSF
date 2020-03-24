package com.example.scopes;

public class MyClass {

	/*
	 * What are Scopes: the lifetime of a variable
	 * 
	 * 4 scopes:
	 * 
	 * 1. Class/Static - variables exist for the lifetime of the class and exist
	 * within the class itself
	 * 
	 * 2. Object/Instance - objects field/state variables exist for the lifetime of
	 * the object and exist within the object itself
	 * 
	 * 3. local/Method - parameters and any variables defined at the method level.
	 * VAriables exist for the lifetime of the method call
	 * 
	 * 4. Block/Loop - any variable defined within the curly braces or a control
	 * flow statement
	 */

	public static int i; // class/static scope
	/*
	 * static keyword when used with a variable makes the variable belong to the
	 * class. AKA there is only one copy of this variable for the entire class. YOu
	 * can access this variable's value from within any scope in this class
	 * 
	 * if do not have static then need to create the in inside of any other method
	 * you are suing
	 */

	static {
		int i = 5; // block scope since inside curly braces
	}

	public static void main(String[] args) {

		int k = 7; // Local/Method scope

		for (int j = 0; j < 3; j++) {
			int m = 10; // m is block scope since take innner most scope
		}

		MacAndCheese mc = new MacAndCheese(true, "shell", 3);
		// type of noodle or any of the other fields are in -> objects scope
	}

}

class MacAndCheese { // cannot put an access modifier "public" because

	boolean isDelicious; // Boolean is in class scope
	String typeOfNoodle;
	int numOfCheeses;

	public MacAndCheese(boolean isDelicious, String typeOfNoodle, int numOfCheeses) {
		super();
		this.isDelicious = isDelicious;
		this.typeOfNoodle = typeOfNoodle;
		this.numOfCheeses = numOfCheeses;
	}

}
