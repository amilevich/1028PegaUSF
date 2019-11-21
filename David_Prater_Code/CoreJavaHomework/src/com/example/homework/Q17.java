package com.example.homework;

import java.util.Scanner;

public class Q17 {

	// Q17. Write a program that calculates the simple interest on the principal,
	// rate of interest and number of years provided by the user. Enter principal,
	// rate and time through the console using the Scanner class.
	// Interest = Principal* Rate* Time
	
	Scanner sc = new Scanner(System.in);
	
	public void calculateInterest() {
		// Get user input for principal, rate, and time
		System.out.println("What is the starting principal amount?");
		double principal = sc.nextDouble();
		System.out.println("What is the interest rate? ( 0 < rate < 1)");
		double rate = sc.nextDouble();
		System.out.println("What is the duration of time in years?");
		double time = sc.nextDouble();
		
		// Calculate Simple Interest
		double simpleInterest = principal * rate * time;
		
		System.out.println("Net Interest: " + simpleInterest);
	}

}
