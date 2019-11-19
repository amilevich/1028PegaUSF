package com.example.homework;

public class Q4 {

	// Write a program to compute N factorial.
	public int factorial(int N) {

		// If N = 0 or 1 print 1
		// Else multiply N by itself minus 1
		// 4*3*2*2*1
		if(N == 1 || N == 0) {
			return 1;
		} else {
			return (N * factorial(N - 1));	
		}

	}

}
