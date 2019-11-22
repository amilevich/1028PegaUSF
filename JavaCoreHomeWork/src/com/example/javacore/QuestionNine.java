package com.example.javacore;

import java.util.ArrayList;

/*
 * Create an ArrayList which stores
 *  numbers from 1 to 100 and prints out all the prime 
 *  numbers to the console.
 */
public class QuestionNine {

	public static void main(String[] args) {
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		//storing numbers 1 to 100 
		for(int i = 1; i < 100; i++) {
			arr.add(i);
		}
		
		
			for(Integer a : arr) {
				System.out.println(a);
			}
				
			 for(int i = 0; i < arr.size(); i++) {
				 if(!isPrime(arr.size())) {
					 arr.remove(arr.get(i));
					 i--;
				 }
			 }
			 System.out.println(arr);
	}
	// getting prime numbers 
	public static boolean isPrime(int p) {
		boolean bool = true;
		for(int i = 2; i < p; i++) {
			if( p % i == 0) {
				bool = false;
			}
		}
		return bool;
	}
}
	
	


