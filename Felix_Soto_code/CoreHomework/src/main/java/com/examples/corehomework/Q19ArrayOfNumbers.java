package com.examples.corehomework;

import java.util.ArrayList;
import java.util.Arrays;

public class Q19ArrayOfNumbers {

	public static void main(String[] args) {
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		for(int i = 1; i <= 10; i++)
			arrList.add(i);
		
		int sumOfEven = 0;
		int sumOfOdd = 0;
		for(int n : arrList) {
			if(n % 2 == 0) 				
				sumOfEven = sumOfEven + n;
				else
					sumOfOdd = sumOfOdd + n;
		}
		
		System.out.println("Here is the list of numbers: " + Arrays.toString(arrList.toArray()));
		System.out.println("Sum of even numbers: " + sumOfEven);
		System.out.println("Sum of odd numbers: " + sumOfOdd);
		
		System.out.println();
		System.out.println("Removing prime numbers: ");
		for(int i = 0; i <= 10; i++) {
			if(isPrime(i)) { 
				arrList.remove(new Integer(i));
			}
		}
			
		System.out.println("Here is the list of the rest numbers from the array: " + Arrays.toString(arrList.toArray()));
	
	}
	
	public static boolean isPrime(int n) {
		// prime numbers
		if(n % 2 == 0) {
			return false;
		}
		int i, m = 0;
		m = n / 2;
		for(i = 2; i <= m; i++) {
			if( n % i == 0) {
				return false;
			}
		}
		return true;
	}
}