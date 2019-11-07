package com.example.wrapper;

import java.util.ArrayList;
import java.util.List;

public class MyClass {

	public static void main(String[] args) {
		
		Integer i = new Integer(2);
		System.out.println(i);
		//boxing -> primitive to wrapper
		//unboxing -> wrapper to primitive
		
		Float f = 998f; //boxing
		float tempFloat = f; //unboxing
		
		ArrayList<Integer> aVerySpecialListOfIntegers = new ArrayList<Integer>();
		Boolean b = false; 
		boolean temp = b;
		
	}

}
