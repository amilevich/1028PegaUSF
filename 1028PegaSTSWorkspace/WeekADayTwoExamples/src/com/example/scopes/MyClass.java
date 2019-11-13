package com.example.scopes;

public class MyClass {
	
	/*
	 * Scopes
	 * lifetime of a variable
	 * 
	 * 4 scopes:
	 * 
	 * Class / Static -vars exist for lifetime of class and exist within class
	 * 
	 * Object / Instance - the object's field/state variables
	 * exist for lifetime of the object and exist within object
	 * 
	 * Local / Method - parameters and any variables defined at the method level. Vars exist for the lifetime of method call
	 * 
	 * Block / Loop - any var defined within the {} or control flow statement
	 */
	
	public static int i; //class scope
	/*
	 * static keyword used with a variable makes this variable
	 * belong to the class. AKA only one copy of this variable
	 * for the entire class. You can access this var's value
	 * from within any scope in this class.
	 */
	
	static {
		int i = 5; //block scope
	}
	
	public static void main(String[] args) {
		int k = 7; //method scope
		for(int j = 0; j<3; j++) {
			int m= 10; // block scope
		}
		
		MacAndCheese mc = new MacAndCheese(true, "shell", 3);
		// typeOfNoodles -> obj type
	}
	
	class MacAndCheese{
		boolean isDelicious; //class scope
		String typeOfNoodle;
		int numOfCheeses;
		public macAnCheese(boolean isDelicious, String typeOfNoodle, int numOfCheeses) {
			super();
			this.isDelicious = isDelicious;
			this.typeOfNoodle = typeOfNoodle;
			this.numOfCheeses = numOfCheeses;
		}
		
		
	}
	
}
