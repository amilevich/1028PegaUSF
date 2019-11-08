package com.example.helloworld;

import javax.sound.midi.Synthesizer;

public class Giraffe {

	boolean hasneck = true; // variable decoration
	// whenever you give a value to a variable it is called "initialization"
	int numOfSpots = 20_124; // underscores makes it easy to read but does not affect the value
	double height = 12.7;
	String name = "Geroge";

	/*
	 * variable - container for a value that is stored and indentifier in memory
	 * 
	 * variables have a type -> determines what sort of value it stores primitive
	 * data type - variables that store simple values
	 * 
	 * 8 in java
	 * 
	 * float -32 bits double -64 bits int char 'a' byte short boolean -t/f long
	 * 
	 * Java is strictly typed - whenever you declare anything you MUST declare a
	 * type. Everything has a type (variable, objects)
	 * 
	 */

	public static void eat() {

		System.out.println("Eating");
	}

	public void walk() {
		System.out.println("walking around in a circle! woo!");
	}

}
