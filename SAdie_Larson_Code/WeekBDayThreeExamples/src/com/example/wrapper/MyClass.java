package com.example.wrapper;

import java.util.ArrayList;
import java.util.List;

public class MyClass {

	public static void main(String[] args) {

		Integer i = new Integer(2);
		System.out.println(i);
		// boxing -> primitive to wrapper

		Float f = 998f; // //boxing --> the f at the end is specific for float if don't put it will
						// think you are making a double
		float tempFloat = f; // unboxing

		List<Integer> arrList = new ArrayList<Integer>();
		Boolean b = false; //boxing
		boolean temp = b; //unboxing
	}

}
