package com.example.homework;

import java.util.ArrayList;

public class Q12 {
	// Q12. Write a program to store numbers from 1 to 100 in an array. Print out
	// all the even numbers from the array. Use the enhanced FOR loop for printing
	// out the numbers.
	
	public void printEven() {
		ArrayList<Integer> intList = new ArrayList<Integer>();
		
		// Add ints 1-100 to intList
		for(int i = 1; i <= 100; i++) {
			intList.add(i);
		}
		
		// Print out even numbers in intList
		for(int i : intList) {
			if( i % 2 ==0 ) {
				System.out.print(i + " ");
			}
		}
		
	}

}
