package com.example.helloworld;

public class MyClass {

	// naming conventions
	/*
	 * multi line comment
	 * 
	 * Class - TitleCase, named after nouns packages - lowercase variables -
	 * camelCase, pascalCase interfaces - TitleCase, named after adjectives methods
	 * - camelCase, usually a verb
	 * 
	 * (Note: Java is case sensitive!)
	 */

	public static void main(String[] args) {
		/*
		 * public - access modifier, there is no restriction of access static - keyword
		 * that means you do not have to instantiate or create an object to call on this
		 * method void - it does not return anything main - name of the method String[]
		 * args - array of type String called "args" used for command line arguments
		 * that are passed as strings
		 */

		// main method
		// it is the entry point of your program
		// the method from which the JVM can
		// run your program

		// System.out.println("Hey, guyz!");
		// System.out.println("Bye, guyz!");

		// instantiate an object of type giraffe
		Giraffe gif = new Giraffe();
		Giraffe gif1 = new Giraffe();
		Giraffe gif2 = new Giraffe();
		Giraffe gif3 = new Giraffe();
		Giraffe gif4 = new Giraffe();
		// gif.eat();
		gif.walk();

		Giraffe.eat();
		gif3.walk();
		
		System.out.println("Giraffe number 2 has " +  gif4.numOfSpots + " spots");
		System.out.println("Giraffe's name is " + gif1.name);
	}

}
