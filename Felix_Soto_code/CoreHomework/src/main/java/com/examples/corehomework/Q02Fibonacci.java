package com.examples.corehomework;

public class Q02Fibonacci {
	public static void main(String[] args) {
		int i;
		int a = 0;
		int b = 1;
		int c = 0;
		int n = 25;
		n = n - 2;
		System.out.println(a);
		System.out.println(b);
		for (i = 1; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
			System.out.println(c); 
		}
	}
}