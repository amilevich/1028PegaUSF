package com.example.core;

import java.util.Scanner;

/*
 * Write a program that calculates the simple interest on the principal,
 * rate of interest and number of years provided by the user. 
 * Enter principal, rate and time through the console using the Scanner class.
Interest = Principal* Rate* Time

 */
//TO DO: double check
public class Q17 {
public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		while(true) {
			double temp = interest();
			System.out.println("Simple interest is: " + temp);
			System.out.println("---------------------------");
		}
	}

	public static double interest() {
		System.out.println("Please enter your principal: ");
		double a = sc.nextDouble();
		System.out.println("Please enter your rate of interest: ");
		double b = sc.nextDouble();
		System.out.println("Please enter your time in years: ");
		double c = sc.nextDouble();
		
		return a*b*c;
		
	}
}
