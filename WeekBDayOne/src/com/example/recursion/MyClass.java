package com.example.recursion;

public class MyClass {
	
	/*
	 * Recursion - is a process in which a method calls
	 * itself continuously.
	 * A method in Java that calls itself is called a 
	 * recursive method.
	 * 
	 * The idea is to represent a problem in terms of one
	 * or more smaller problems, and add one or more
	 * base conditions that stop the recursion.
	 */

	public static void main(String[] args) {
		//System.out.println("Factorial of 4: " + factorial(4));
		/*
		 * Application that calculates a factorial of a number
		 * 4! = 4 * 3 * 2 * 1 
		 * 3! = 3 * 2 * 1
		 */
		/*
		 * Fibonacci sequence
		 * 0, 1, 1, 2, 3, 5, 8, ....
		 * print out the first 15 numbers
		 */
		System.out.print(n1 + " " + n2);
		printFibo(15);
	}
	
	public static int n1 = 0, n2 = 1;
	
	public static void printFibo(int count) {
		if(count > 0) { //&& means both conditions must be met
		int n3 = n1 + n2; //n3 = 1	n3 = 3
		n1 = n2; //n1 = 1			n1 = 2
		n2 = n3; //n2 = 2			n2 = 3
		System.out.print(" " + n3);
		printFibo(count-1);
		}
	}
	
	public static int factorial(int n) { //O(N)
		if( n == 1) {
			return 1;
		}
		else {
			return (n * factorial(n-1));
		}
	}


}
