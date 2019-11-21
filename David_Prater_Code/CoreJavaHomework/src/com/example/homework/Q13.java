package com.example.homework;

public class Q13 {

	// Q13. Display the triangle on the console as follows using any type of loop.
	// Do NOT use a simple group of print statements to accomplish this.
	// 0
	// 1 0
	// 1 0 1
	// 0 1 0 1

	// This question was hard....
	public void printTriangle() {
		System.out.println("");

		// First for loop sets up rows
		for (int i = 1; i <= 4; i++) {
			
			// Second and second row
			if (i == 2 | i == 3) {
				for (int k = 0; k < i; k++) {
					System.out.print((k + 1) % 2);
				}
				// First and fourth row
			} else {
				for (int j = 0; j < i; j++) {
					System.out.print((j) % 2);
				}
			}
			System.out.println();

		}
	}

}
