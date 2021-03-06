package com.example.helloworld;

public class Giraffe {

	boolean hasNeck = true; //variable declaration
	//whenever you give a value to a variable - initialization
	int numOfSpots = 202_124;
	//underscores make it easier to read but do not affect the value
	double height = 12.7;
	String name = "George";
	
	//naming variables
	/*
	 * can only use numbers, letters, $ and _ characters
	 * cannot begin with a number
	 * cannot be a reserved Java keyword
	 */
	
	public static void eat() {
		System.out.println("Eating");
	}
	
	public void walk() {
		System.out.println("walking around in a circle! woo!");
	}
	
	/*
	 * variables - container for a value that is stord and
	 * identified in memory
	 * 
	 * variables have a type -> determines what sort of value
	 * it stores
	 * variables have a name -> this is what makes it possible
	 * to access the value
	 * 
	 * Primitive data types - variables that store simple values
	 * 
	 * 8 in Java
	 * 
	 * 4 bits - 1 byte
	 * nibble - 1/2 a byte
	 * 
	 * float - 32 bits
	 * double - 64 bits
	 * int
	 * char - 'a'
	 * byte
	 * short
	 * boolean - T/F
	 * long
	 * 
	 * Java is strictly typed - whenever you declare anything
	 * you MUST declare a type. Everything has a type 
	 * (variables, objects)
	 */
	
}
