package com.example.arrays;

public class MyClass {
	/*
	 * array - collection of elements of the same type and fixed size
	 */
	
	public static void main(String[] tuesday) {
		
		int tempOne[] = {1,2,3,4};
		//System.out.println(tempOne[0]); // index starts at 0
		
		tempOne[2] = 8;
		//System.out.println(tempOne[2]);
		
		int tempTwo[] = new int [9004];
		//an aray of size 9004
		System.out.println(tempTwo[3]);
		// int array s are init as 0 by default
		
//		for(int i = 0; i<tempTwo.length; i++) {
//			System.out.println(tempTwo[i]);
//		}
		
		Object objArray[] = new Object[5];
		//an array of type Object with size 5
		
//		String[] planets = {"Mercury", "Venus", "Earth", "Mars", "Jupiter"};
//		for(int n = 0; n<planets.length; n++) {
//			System.out.println(planets[n]);
//		}
//		
//		//print in reverse
//		System.out.println("Prining in reverse.");
//		for(int m = planets.length -1; m>=0; m--) {
//			System.out.println(planets[m]);
//			//since indexing is zero based,
//			//the last element has index array length minus one
//		}
		
		int tempFour[][] = { {9,10,11}, {4,2,7}, {6,6,5} };
		System.out.println(tempFour[1][0]); //2nd row, 1st column
		
		int tempSix[][] = new int [10][12];// 10 rows, 12 columns
		tempSix[5][8]= 80; //6th row, 9th column
		System.out.println(tempSix[5][8]);
	}
}
