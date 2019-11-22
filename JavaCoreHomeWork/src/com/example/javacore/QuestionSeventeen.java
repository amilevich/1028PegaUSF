package com.example.javacore;

import java.util.Scanner;

/* Write a program that calculates the simple interest on the principal,
 *  rate of interest and number of years provided by the user. 
 *  Enter principal, rate and time through the console using the Scanner class. 
 */
public class QuestionSeventeen {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double rate;
		double principal;
		int time;
		double interest;
		
		System.out.println("Please enter the principal rate: ");
		principal = sc.nextDouble();
		
		System.out.println("Please enter the rate: ");
		rate = sc.nextDouble();
		
		System.out.println("Please enter the time: ");
		time = sc.nextInt();
		
		interest = principal * rate * time;// calculates the interest for a given rate and time 
		System.out.println("This is your interest: ");
		System.out.println(interest);

	}

}
