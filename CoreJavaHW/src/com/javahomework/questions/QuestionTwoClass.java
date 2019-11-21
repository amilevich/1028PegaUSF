package com.javahomework.questions;

public class QuestionTwoClass {
	public static void main(String[] args) {
		/*
		 * Write a program to display the first 25 Fibonacci numbers beginning at 0.
		 * */
		// i call the method fibonacci here
		Fibonacci();

	}
	public static int n=25,a1=0,a2=1; //this where i am declaring my variables
	// first i need to do a method to print out the fibonacci sequence
	
	public static void Fibonacci() {
		System.out.println(" " + a1); //here i start with 0
		System.out.println(" " + a2);// then i display 1
		for(int i = 1; i<=n-2; ++i) { //then the for loop iterates by one each time
			int sum = a1+a2;
			a1=a2;
			a2=sum;
			System.out.println(" " + sum);//print out the result
		}
	}
}
