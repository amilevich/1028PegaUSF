package com.homework.QTwo;

public class FibonacciNumber {

 
	
	public static void main(String[] args) {
		
		int sum=0;
		int A=0, B=1;
		// Runs  25 times
		System.out.print(A + " " + B);
		for (int i= 2; i < 25; i++) {
		
			
			// adds the or
			 sum = A + B;
			 // prints ths sum of the two numbers
			 System.out.print(" " + sum);
			 // sets the previous number to A
			  A= B;
			 // sets the sum to B
			  B=sum;
		}
		

	}

}
