package com.javahomework.questions;

import java.util.Scanner;

public class QuestionSixClass {
	
	
	
	public static boolean even(int n) 
	{ 
		/*
		 * Write a program to determine if an integer is even 
		 * without using the modulus operator (%)
		 * */
		Scanner sc = new Scanner(System.in); //instantiating a scanner object
		int num; //declaring my integer variable
		System.out.println("Enter a number");
		num = sc.nextInt(); //storing users number input in the num variable
		
		if(even(num)!=true) { //the condition says if is true it is even if it is not then odd
			System.out.println("odd");
		}else {
			System.out.println("even");
		}
	
	    return ((n / 2) * 2 == n); //this is the formula to determine if it is even or not
	} 
}
