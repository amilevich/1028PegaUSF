package com.example.helloworld;

public class MyClass {
	//naming conventions
	/*
	 * *multi line comment
	 * Class - TitleCase
	 * packages - lowercase
	 * variables - camelCase, pascalcase
	 * interfaces - TitleCase, named after adjectives
	 * methods - camelCase, usually a verb
	 * 
	 * (Note: Java is case sensitive!))
	 */
	
	public static void main (String[] args) 
	{
		
		/*
		 * public - access modifier, there is no restriction of access
		 * static - keyword no need to instantiate or create an object to call this method
		 * void - it does not return anything
		 * main - name of the method
		 * String[] args - array of type called "args"
		 * used for command line arguments that are passed
		 * as strings
		 */
		
		//main method
		// it is the entry point of your program
		//the method from which the JVM can
		// run your program
		
		//System.out.println("Hello World");
		//System.out.println("Bye World");
		
		//instantiate an object of type giraffe
		
		//Giraffe gif = new Giraffe();
		//gif.eat();
		//gif.walk();
		
		Giraffe.eat();
	}
	
}
