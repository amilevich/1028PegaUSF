package com.example.recursion;

public class MyClass {

	/*
	 * REcursion - is a process in which a method calls itself continuously
	 * 
	 * A method in Java that calls itself is called a recursive method
	 * 
	 * The idea is to represent a problem in terms of one or more smaller problems,
	 * and add one or more base conditions that stop the recursion
	 */

	public static void main(String[] args) {

		/*
		 * Application that calculates a factorial of a number
		 * 
		 * Ex: factorial of 4! = 4*3*2*1 = 24
		 * 
		 */

		/*
		 * 
		 * Fibonacci Sequence - add first two numbers to get next one in sequence
		 * 1,2,3,4,5,8,..... print out the first 15 numbers
		 */
		System.out.println(factorial(4));

		System.out.print(n1 + ", " + n2 + ", ");
		printFibo(15);
	}

	public static int factorial(int n) { //O(N) 

		if (n == 1) {
			return 1;
		} else {
			return (n * factorial(n - 1));
		}
	}

	public static int n1 = 0, n2 = 1, n3 = 0;

	public static void printFibo(int count) {
		if (count > 0) {
			n3 = n1 + n2;
			System.out.print(n3 + ", ");
			n1 = n2;
			n2 = n3;
			printFibo(count - 1);
		}
	}

}
