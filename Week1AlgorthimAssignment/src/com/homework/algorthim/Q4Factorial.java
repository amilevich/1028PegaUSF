package com.homework.algorthim;

public class Q4Factorial {

	
	public int factorial(int n) {
		if(n == 0) {
			return 1;
		}else {
			return (n*factorial(n-1));
		}
	}
		
		//Attempt 1
//		int n = 5;
//		int sum =  n*(n-1)*(n-2)*(n-3)*(n-4);		
//		n=n-1;
//		
//		n*(n-(1))
//		System.out.println(sum);

}
