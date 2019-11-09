package com.example.wrapper;

import java.util.ArrayList;

public class MyClass {

	public static void main(String[] args) {

		Integer i = new Integer(2);
		System.out.println(i);
		//boxing -> primitive to wrapper
		
		Float f = 998f;// boxing
		
		float tempFloat = f; //unboxing -> wrapper to primitive 
		// we have 8 wrapper classes
		
		ArrayList<Integer> aVerySpecialListOfInteger = new ArrayList<Integer>();
		Boolean b = false; //boxing
		boolean temp = b; //unboxing 
		
		
	}

}
