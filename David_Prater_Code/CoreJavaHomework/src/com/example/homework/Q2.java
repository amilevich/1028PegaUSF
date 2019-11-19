package com.example.homework;

public class Q2 {

	// Write a program to display the first 25 Fibonacci numbers beginning at 0.
	public void fibonacciSequence() {
		// This formats the output to put a line between this and question 1
		System.out.println("");
		// Print first two numbers
		System.out.print(0 + " " + 1 + " ");

		// Initialize the first two values of the fibonacci sequence
		// And declare an empty int for the actual fibonacci number
		int n1 = 0;
		int n2 = 1;
		int n3;

		// This loop calculates the numbers between 2 and 25
		for (int i = 2; i <= 25; i++) {
			// Set n3 to the sum of the two previous numbers
			n3 = n1 + n2;
			System.out.print(" " + n3);
			// Assign n1 and n2 to the next two numbers in the fibonacci sequence
			n1 = n2;
			n2 = n3;
		}

	}

}
