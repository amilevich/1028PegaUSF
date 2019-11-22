package com.Q4;

public class Q4 {
	
	// Q4. Write a program to compute N factorial.
	 
		 static int factorial (int n) {
			 if(n==1) {
				 return 1;
			 } else { 
				 return(n*factorial(n-1));
			 }	  
		 }
	public static void main(String[] args) {
		System.out.println("'4' factorial: " + factorial(4));

	}

}
