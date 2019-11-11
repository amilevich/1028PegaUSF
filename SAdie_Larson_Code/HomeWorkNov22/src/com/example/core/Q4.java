package com.example.core;
//DONE
/*
 * Write a program to compute N factorial.
 */

//CHECK: if negative 1 is complex and verify 0 is 1
public class FactorialQ4 {
//DONE
	public static int evenOdd = 2;

	public static void main(String[] args) {

		System.out.println(factorial(5));
		System.out.println(factorial(4));
		System.out.println(factorial(0)); // technically would return since factorial
		// is n!/(k!(n-k)! would be 0/0

		// System.out.println(factorial(-1));
		// System.out.println(factorial(-4));
		// System.out.println(factorial(-3));

	}

	public static int factorial(int n) {
		/*
		 * uncomment if taking factorial of negative numbers (considered as complex
		 * factorial)
		 */

		// if (n < 0) {
		// n *= -1;
		// //System.out.println(n);
		// evenOdd = n;
		// // return factorial(n);
		// }
		if (n < 2) {
			if (evenOdd % 2 == 0) {
				return 1;
			} else {
				return -1;
			}
		} else {
			return factorial(n - 1) * n;
		}
	}
}
