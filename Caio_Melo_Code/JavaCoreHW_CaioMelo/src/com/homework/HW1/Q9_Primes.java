package com.homework.HW1;

import java.util.ArrayList;

/*
 * Q9 - Method to pick tell if number is prime, 
 * and method to return an arraylist of prime numbers
 * leading up the one passed as a parameter(100)
 */

public class Q9_Primes {
	public static void main(String[] args){
		

		System.out.println(pickPrime(100).toString());

	}

public static ArrayList<Integer> pickPrime(int x){
	
	ArrayList<Integer> primeNums = new ArrayList<Integer>();
	
	for(int y = 0;y<x;y++) {
		if(isPrime(y)) {
			primeNums.add(y);
		}
	}
	
	
	return primeNums;
}
	
	
	
public static boolean isPrime(int x) {
	
	for(int i=2;i<x;i++) {
		
		if(x%i == 0) { //If x is cleanly divisible by any number leading up to it, it is not prime.
			return false;
		}
	}
	return true;
}
}
