package com.example.wrapper;

import java.util.ArrayList;

public class MyClass {

	public static void main(String[] args) {

		Integer i = new Integer(2);
		System.out.println(i);
		// boxing -> primitive to wrapper
		//unboxing -> wrapper to primitive 
		
		//left side of equal sign is declaration and right side is assignment
		
		Float f = 998f; // Boxing; Float with a capital F is a class. Float f is an object
		float tempFloat = f; //unboxing ;  Float with a lowercase f is a primitive type; 
		
		ArrayList<Integer> aVerySpecialListOfInteger = new ArrayList<Integer>();
		Boolean b = false;
		boolean temp = b;
	}

}
