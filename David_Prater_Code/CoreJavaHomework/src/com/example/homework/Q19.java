package com.example.homework;

import java.util.ArrayList;
import java.util.Iterator;


public class Q19 {

	// Q19. Create an ArrayList and insert integers 1 through 10. Display the
	// ArrayList. Add all the even numbers up and display the result. Add all the
	// odd numbers up and display the result. Remove the prime numbers from the
	// ArrayList and print out the remaining ArrayList.
	ArrayList<Integer> arrayList = new ArrayList<Integer>();	
	public void arrayListManipulation() {
		// Add nums to ArrayList
		for(int i = 0; i <= 10; i++) {
			arrayList.add(i);
		}
		
		
		System.out.println(sumEvenNumbers(arrayList));
		System.out.println(sumOddNumbers(arrayList));
		System.out.println(removePrime(arrayList));
		

	}
	
	// Check for even numbers then sume them
	public int sumEvenNumbers(ArrayList<Integer> list) {
		int sum = 0;
		for(Integer i : list) {
			if(i % 2 == 0) {
				i += i;
				sum = i;
			}
		}
		return sum;
	}
	
	// Check for odd numbers then sum them
	public int sumOddNumbers(ArrayList<Integer> list) {
		// Sum odd numbers
		int sum = 0;
		for(Integer i : list) {
			if(i % 2 == 0 || i == 1) {
				i += i;
				sum = i;
			}
		}
		return sum;
	
	}
	

	// This method loops through the ArrayList and calls checkPrime() to determine if num is prime
	// If it is prime remove the number from the list
	public ArrayList<Integer> removePrime(ArrayList<Integer> list) {
		// Declare an Iterator because using .remove() wont work in for loop
		Iterator<Integer> iterator =list.iterator();
		
		while(iterator.hasNext()) {
			int number = iterator.next();
			if(checkPrime(number)) {
				iterator.remove();
			}
		}
		
		return list;
	}
	
	// Method from question 9 that determines if a number is prime
	public static boolean checkPrime(int numberToCheck) {
		int remainder;
		for (int i = 2; i <= numberToCheck / 2; i++) {
			remainder = numberToCheck % i;
			// if remainder is 0 than numberToCheckber is not prime and break loop. Else
			// continue loop
			if (remainder == 0) {
				return false;
			}
		}
		return true;

	}
	
	

}
