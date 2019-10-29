package com.example.arrays;

public class MyClass {

	/*
	 * array - collection of elements of the same type and of fixed size
	 * 
	 */

	public static void main(String[] args) {

		// int tempOne[] = { 1, 2, 3, 4 };
		//
		// // System.out.println(tempOne[0]); //will print out 1 since index starts at 0
		// tempOne[2] = 8;
		// System.out.println(tempOne[2]);
		//
		// int tempTwo[] = new int[9004]; // an array of size 9004
		// System.out.println(tempTwo[2]); // will print out 0 since default filled in
		// is zero for int
		//
		// System.out.println(tempTwo); // will print out address of array
		//
		// for (int i = 0; i < tempTwo.length; i++) {
		// System.out.println(tempTwo[i]); //will print out all elements in array
		// }

		// Object objArray[] = new Object[5]; // created an array of type Object with
		// size of 5
		// this was just to show us that an object could be created
		
		// String[] planets = { "Mercury", "Venus", "Earth", "Mars", "Jupiter" };
		//
		// for (int i = 0; i < planets.length; i++) {
		// System.out.println(planets[i]); // will print out all elements in array
		// }
		//
		// // print in reverse
		// System.out.println("Printing planets in reverse");
		// for (int i = planets.length - 1; i >= 0; i--) {
		// System.out.println(planets[i]); // will print out all elements in array
		// // since indexing is zero based,
		// // the last element has index array length minus one
		// }

		// int tempFour[][] = { {9, 10, 11},
		// {4, 2, 7},
		// {6, 6, 5}};
		// System.out.println(tempFour[1][0]); // second row, first column
		// System.out.println(tempFour[2][2]);

		int tempFive[][][][][][][][]; // totally possible but not good practice

		int tempSix[][] = new int[10][12];
		tempSix[5][8] = 80; // sixth row, ninth column
		System.out.println(tempSix[5][8]);

	}
}
