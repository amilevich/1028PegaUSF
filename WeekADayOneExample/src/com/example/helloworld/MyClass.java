package com.example.helloworld;

public class MyClass {

	// naming conventions

	/*
	 * Class - TitleCase, named after nouns packages - lowercase variable -
	 * camelCase, pascalCase interface - TitleCase, named after adjectives methods
	 * -camelCase, usually a verb
	 * 
	 * note: java is case sensitive!
	 */

	public static void main(String[] args) {
		/*
		 * public- access modifier, there is not restriction of access
		 *  static - keyword that means that you don't have to instantiate or create an object to call on
		 * this method 
		 * void - it does not return anything main - the name of the method
		 * String [] args - array of type String called "args" used for command line
		 * arguments that are passed as strings
		 * 
		 */

		// Main method is the entry point of your program
		// it is the method from which JVM can run your program

		// System.out.print("Hello World");
		
		//instantiate an object of type giraffe
		
     	Giraffe gif = new Giraffe();
     	Giraffe gif1 = new Giraffe();
     	Giraffe gif2 = new Giraffe();
     	Giraffe gif3 = new Giraffe();
     	Giraffe gif4 = new Giraffe();

//		gif.eat();
		gif.walk();
		
		Giraffe.eat(); // calling the eat method 
		gif3.walk();
		System.out.println("Giraffe number 2 has " +  gif4.numOfSpots + "  spots");
		System.out.println("Giraffe's name is " + gif1.name);
	

	}

}
