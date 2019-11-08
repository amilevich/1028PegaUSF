package com.example.recurssion;

public class MyClass {

		/*
		 * recursion is a process in which a method calls itself continuously
		 * a method in java that calls itself is called a recursive method.
		 * 
		 * the idea is to represent a problem in terms of one or more smaller problems, and add one or more base conditions that stop the recursion.
		 * */
	public static void main(String[] args) {
		
			/*
			 * Application that calculates a factorial of a number
			 * 4! = 4*3*2*1
			 * 3! = 3*2*1
			 * */
		//System.out.println("Factorial of 4: " + factorial(4));
		
		/*
		 * fibonacci sequence
		 * 0, 1, 1, 2, 3, 5, 8,....
		 * print out the first 15 numbers
		 * */
		System.out.print(n1 + "" + n2);
		printFibo(15);
	}
	
	public static int factorial(int n) {
		if(n == 1) {
			return 1;
		} else {
			return n*factorial(n-1);
		}
	}
	
	public static int n1 = 0, n2 =1;
	public static void printFibo(int count) {
		if(count > 0) {
		int n3 = n1 + n2; //n3 = 1
		n1 = n2;// n1= 1
		n2 = n3;
		System.out.print(" " + n3);
		printFibo(count-1);
		}
	}
}
