package com.homework.algorthim;

public class Q2Fibonacci {

		public void printFib(int n) {
			int f1 = 0, f2 = 1, i;
			if(n<1) {
				return;
			}
			for( i = 0; i < n ; i++) {
				System.out.println(f1);
				int nextInt = f1+f2;
				f1 = f2;
				f2= nextInt;
			}
			
		}
}
