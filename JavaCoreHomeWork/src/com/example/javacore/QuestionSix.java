package com.example.javacore;

import java.util.Scanner;

public class QuestionSix {
/*
 * Write a program to determine if an integer is even without 
 * using the modulus operator (%)
 */
	public static void main(String[]args ) {
		 
	Scanner sc = new Scanner(System.in);
	int n;
	System.out.println("Enter a number");
	
	n =sc.nextInt();
	
	if(even (n)) {
		System.out.println("Even");
	}else {
		System.out.println("Odd");
	}
	
	}

 static boolean even(int n) {
	
	boolean even = true;
	
	for(int i = 1; i <= n; i++) {
		even = !even;
	}

	return even;
}
}
