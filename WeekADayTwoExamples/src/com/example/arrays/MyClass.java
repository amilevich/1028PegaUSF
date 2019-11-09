package com.example.arrays;

public interface MyClass {

	/*
	 * Array -> collection of elements of the same type and fixed size
	 * 
	 */
	
	public static void main(String[] args) {
		
		int tempOne[] = {1,2,3,4};
		//System.out.println(tempOne[0]);
		tempOne[2] = 8;
		System.out.println(tempOne[2]);
		
		int tempTwo[] = new int[9004];
		// an array of size 9004
		
		System.out.println(tempTwo[3]);
		// int arrays are initialized at 0 by default
		
//		for (int i = 0; i < tempTwo.length; i++) {
//			System.out.println(tempTwo[i]);
//		}
		
		Object objArray[] = new Object[5];
		// an arrays of type object with size of 5
		
		String[] planets = {"Mercury","Venus","Erth","Mars","Jupiter"};
		
		for(int n = 0; n < planets.length; n++) {
			System.out.println(planets[n]);
		
		}
		
		//print in reverse
		System.out.println("printing planets in reverse");
		System.out.println(" ");
		for(int m = planets.length -1; m >= 0; m--) {
			System.out.println(planets[m]);
			// since indexing is 0 based
			// the last element has index array length minus one
		}
		
		//multidimentional arrays
		
		int tempFour[][] = { {9,10,11}, {4,2,7}, {6,6,5}};
//		System.out.println(tempFour[1][0]);// second row, first column
//		System.out.println(tempFour[0][2]);
//		
		int tempSix[][] = new int [0][12];
		tempSix[5][8] = 80; //sixth row, ninth column
		System.out.println(tempSix[5][8]);
		
		
	}
}
