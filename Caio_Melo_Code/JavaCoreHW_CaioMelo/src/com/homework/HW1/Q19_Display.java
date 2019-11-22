package com.homework.HW1;

import java.util.ArrayList;

public class Q19_Display {
public static void main(String[] args) {
	
	displayList();
}
public static boolean isPrime(int x) {
	
	for(int i=2;i<x;i++) {
		
		if(x%i == 0) {
			return false;
		}
	}
	return true;
}

static void displayList() {
	/*
	 * Add all evens and display result
	 * Add all ods and display result
	 * Remove prime numbers from the arraylist and print out arraylist
	 */
	ArrayList<Integer> displayList = new ArrayList<Integer>();
	int evenSum = 0;
	int oddSum = 0;
	System.out.println("ArrayList Content: ");
	for(int i = 1; i<11 ;i++) {
		System.out.print(i + " ");
		if(!(isPrime(i))) {
			displayList.add(i);
		}
	}
	System.out.println();
	for(int j =0;j<11;j++) {
		if (j%2 == 0) {
			evenSum+=j;
		}
		else {
			oddSum+=j;
		}
	}
	
	System.out.println("Sum of even numbers: " + evenSum);
	System.out.println("Sum of odd numbers: " + oddSum);
	System.out.println("ArrayList after deletion of primes: ");
	for(int x:displayList) {
		System.out.print(x + " ");
	}
	
}
}
