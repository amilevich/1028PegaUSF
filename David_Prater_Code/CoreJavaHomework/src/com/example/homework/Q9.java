package com.example.homework;

import java.util.ArrayList;

public class Q9 {

	// Create an ArrayList which stores numbers from 1 to 100 and prints out all the
	// prime numbers to the console.

	// Get the index then divide by every number until to

	public void printPrimeNumbers() {
		ArrayList<Integer> intList = new ArrayList<Integer>();

		for (int i = 1; i <= 100; i++) {
			intList.add(i);
		}

		//Check if the number is prime
		for (int i : intList) {

			if (checkPrime(i)) {
				System.out.print(i + " ");
			}

		}

	}

	// Check if number is prime
	public static boolean checkPrime(int numberToCheck) {
		int remainder;
		// Divide by two first because because all even numbers are no prime except 2
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
