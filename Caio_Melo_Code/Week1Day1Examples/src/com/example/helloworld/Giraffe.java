package com.example.helloworld;

public class Giraffe {
	
	boolean hasNeck; //variable declaration
	int numOfSpots = 10; //initialization 
	double height;
	String name;
	
	
	Giraffe(){
		
	}
	
	Giraffe(int x, double y){ //Constructor 
		this.numOfSpots = x;
		this.height = y;
	}
	
	public void eat() {
		System.out.println("Eating Om Nom Nom");
	}
	
	public void walk() {
		
	}
	
	/*  
	 * Variables - Container for a value that is stored and identified in memory
	 * 
	 * Variable Type -> Determines what sort of value it stores
	 * 
	 * Variable Name - How to acess the value;
	 * 
	 * Primitive Data Types
	 * Primitive Data types (4 bits a byte)
	 *int
	 * Double 64 bits
	 *Boolean
	 *Char
	 *Byte
	 *Short
	 *Long
	 *Float 32 bits

	 */

}
