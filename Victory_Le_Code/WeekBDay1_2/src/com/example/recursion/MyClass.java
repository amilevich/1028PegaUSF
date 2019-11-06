package com.example.recursion;

public class MyClass {

	/*
	 * Recursion - is a process in which a method calls itself continously. 
	 * A method in Java that calls itself is called a recursive method. 
	 * Recursion is when a method calls itself and we use it to recall all over again
	 * 
	 * The idea is to represent a problem in terms of one or more smaller problems, and add one or more base conditions that stop the recursion. 
	 * 
	 */
	public static void main(String[] args) {
		
		System.out.println("Factorial of 10: " + factorial(4));
		/*
		 * Application that calculates a factorial of a number
		 * 4! = 4 * 3 * 2 * 1
		 * 3! = 3 * 2 * 1
		 * 
		 * recursion is useful because you are repeating the same operation over and over again
		 */
		
		/*
		 * Fibonacci sequence
		 * 0, 1, 1, 2, 3, 5, 8, ....
		 * 
		 * recursion is great here because we are doing the same operation and sequence. 
		 * print out the first 15 numbers
		 */
		
		System.out.print(n1 + " " + n2);printFibo(15);
	}
	public static int n1 = 0, n2 = 1;
	
	public static void printFibo(int count) {
		if(count > 0) { //providing the start and the end
		int n3 = n1 + n2;
		n1 = n2;
		n2 = n3;
		System.out.print(" " + n3);
		printFibo(count-1);
		}
	}
	
	
	public static int factorial(int n) {
		if( n == 1) {
			return 1;
		}
		else {
			return (n * factorial(n-1));
		}
	}
	
	
	

}
