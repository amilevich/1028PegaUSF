package com.example.helloworld;

public class Giraffe {

	boolean hasNeck = true; // variable declaration
	// whenever you give a value to a variable - initialization
	int numOfSpots = 202_124;
	// underscores make it easier to read but does not affect the value
	double height = 12.7;
	String name = "George";

	//naming variables
	/*
	 * can only use numbers, letters, $ and _ characters
	 * cannot begin with a number
	 * cannot be a reversed Java Keyword
	 */

	public static void eat() {
		System.out.println("Eating");
	}

	public void walk() {
		System.out.println("Walking around yee");
	}

	public static void poop() {
		System.out.println("Pooping");
	}
	/*
	 * variables - container for a value that is stored and identified in memory
	 * 
	 * variables have a type -> determines what sort of value it stores
	 * 
	 * variables have a name -> this is what makes it possible to access the value
	 * 
	 * Primitive data types - variables that store simple values
	 * 
	 * 8 in Java:
	 * 
	 * 4 bits - 1 byte nibble - 1/2 byte
	 * 
	 * float - 32 bits double - 64 bits int char - 'a' byte short boolean - T/F long
	 * 
	 * Java is strictly typed (Whenever you declare anything, you MUST have a type)
	 * (variables, objects)
	 */
}
