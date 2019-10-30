package com.example.helloworld;



public class MyClass {
	// naming conventions
	/*
	 * multi line comment
	 * 
	 * Class - TitleCase packages - lowercase variables - camelCase, pascalCase
	 * interfaces - TitleCase, named after adjectives methods - camelCase, usually a
	 * verb
	 * 
	 * (Note: java is case sensitive)
	 */

	public static void main(String[] args) {
		/*
		 * public - access modifier, there is no restriction of access
		 * static - keyword that means you do not have to instantiate
		 * or create an object to call this method
		 * void - it does not return anything
		 * main - the name of method
		 * String[] args - array of type string called "args"
		 * used for the command line arguments that are passed as strings
		 * 
		 * */
		
		// the main method is the entry point of your program
		// it is the method from which the JVM can run your program

//		System.out.println("Hello World!");
//		System.out.println("Bye World!");
		
		//instantiate an object of type giraffe
//		Giraffe gif = new Giraffe();
//		gif.eat();
//		gif.walk();
//		Giraffe.eat();
		Giraffe gif2 = new Giraffe();
		System.out.println("Giraffe number 2 has " + gif2.numOfSpots + " spots ");
	}
}
