package com.questions.homework;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumsExample_9 {
	static List<Integer> primeNums = new ArrayList<Integer>();
	public static void main(String[] args) {
		
		printPrime();
		System.out.println(primeNums);
		
	}
	public static boolean findPrime(int p) {
		
		boolean isPrime = false;
		if(p <= 1) {// all prime numbers are greater than 1
			return false;
		}
		
		for(int i =2; i <= Math.sqrt(p); i++) { //formula for prime number, sq. rt. of a prime is never 0
			if(p % i == 0) {
				return false;
			}
		}
		return true;
	}
	public static void printPrime() {
		int p = 1;
		while(p <= 100) {//Range of 100 ints
			
			if(findPrime(p) == true) {
				primeNums.add(p);
			}
			p +=1;
		}
	}
	
	
}
