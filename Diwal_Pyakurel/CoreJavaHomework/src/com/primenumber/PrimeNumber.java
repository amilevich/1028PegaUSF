package com.primenumber;

import java.util.ArrayList;

public class PrimeNumber {
	public static void main(String[] args) {
		//provide the highest number up to where you want to check the prime number
		getPrime(100);
	}

	public static void getPrime(int numbersUpTo) {

		ArrayList<Integer> allNumbers = new ArrayList<>();
//Each element modulas will be checked with all the numbers from 0 to that pasrticular number
		//if there are only 2 modulas 0 then it is prime
		for(int i =1; i<numbersUpTo+1; i++) {
			int count=0;
			for(int j=1; j<numbersUpTo+1; j++) {
				if(i%j==0) {
					count++;
				}
				
			}
			if(count==2) {
				//counts how many 0 Modulas will be there
				Integer number = new Integer(i);
				allNumbers.add(number);
			}
		}
		
		System.out.println(allNumbers);

	}
}
