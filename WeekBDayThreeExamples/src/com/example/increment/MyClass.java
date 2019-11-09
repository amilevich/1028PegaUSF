package com.example.increment;

public class MyClass {

	public static void main(String[] args) {
 
		int i = 300;
		System.out.println(i + i + " Blue");
		System.out.println("Red " + i + i);
		// order of operations matters
		System.out.println("Red" + i + i / 2);
		System.out.println("Green" + (i + i));
		
		int num = 50;
		System.out.println(num++); //post increment	
	    System.out.println(++num); //pre increment
	
	
	}

}
