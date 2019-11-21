package com.javahomework.questions;

import java.util.Scanner;

public class QuestionFourClass {
	/*
	 * Write a program to compute N factorial.
	 * */
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); //instantiating a scanner object
		System.out.print("Enter number to calculate factorial: ");
		int n = input.nextInt(); //storing the input into an int variable
		System.out.println("Factorial of " + n + " is "+ factorial(n));
	}
	public static int factorial(int n) { //method that takes in an integer number as argument
		if(n == 0) { // if number is 0 return 1 else retutn the number multiplied by itself passed in method
			return 1;
		}else {
			return(n * factorial(n-1));
		}
		
	}
}
