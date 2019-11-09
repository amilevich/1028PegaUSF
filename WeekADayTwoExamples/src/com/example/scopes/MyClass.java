package com.example.scopes;

public class MyClass {
	
	/*
	 * Scopes are lifetimes of variable
	 * 
	 * 4 scopes
	 * 
	 * 1) Local/Method --> parameters and any variables defined at the method level. Variable exist for the lifetime of the method call
	 * 
	 * 2) Class/Static --> variables exist for the lifetime of the class and exist within the class itself
	 * 
	 * 3) Object/Instance --> the object;s field/sate variables exits for the lifetime of the object and exist within the object itself
	 * 
	 * 4) Block/Loop --> any variable defined within the curly braces or a control flow statement
	 */

	public static int i;// class scope
	/*
	 * static keyword when used with a variable makes this variable belong to the class. AKA there is only ONE copy of this variable
	 * for the entire class. You can access this variable's value from within any scope in this class.
	 */
	
	static {
		int i =5;// block scope
	}
	
	public static void main(String[] args) {
		
		int k = 7;// method scope
		
		for( int j = 0; j < 3; j++) {
			int m = 10;// block scope
			
		}		
	}
	
	MacAndCheese mc = new MacAndCheese(true,"shell",3);
	//typeOfNoodles -> object type
	
	public class MacAndCheese{
		boolean isDelicious;//class scope
		String typeOfNoodle;
		int numOfCheeses;
		
		
		public MacAndCheese(boolean isDelicious, String typeOfNoodle, int numOfCheeses) {
			super();
			this.isDelicious = isDelicious;
			this.typeOfNoodle = typeOfNoodle;
			this.numOfCheeses = numOfCheeses;
		}
		
		
		
	}

	
}

    
