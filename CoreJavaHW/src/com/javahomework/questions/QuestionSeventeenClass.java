package com.javahomework.questions;

import java.util.Scanner;

public class QuestionSeventeenClass {
	/*
	 * Write a program that calculates the simple interest on the principal, 
	 * rate of interest and number of years 
	 * provided by the user. Enter principal, 
	 * rate and time through the console using the Scanner class. 
	 * */
	
 public static void main(String[] args) {
	Scanner sc = new Scanner(System.in); // instantiating a scanner object
	//declaring the variables i will need
	double principle;
	double rate;
	int time;
	double interest;
	
	System.out.print("Please enter principle: ");
	principle = sc.nextDouble();
	System.out.print("Please enter the rate: ");
	rate = sc.nextDouble();
	System.out.println("Please enter the time: ");
	time = sc.nextInt();
	interest = principle * rate * time; // formula to calculate the interest
	System.out.print("Your interest is: ");
	System.out.println(interest);
	
 	}
}
