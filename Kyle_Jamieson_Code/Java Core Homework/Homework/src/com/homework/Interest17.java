package com.homework;

import java.util.Scanner;

public class Interest17 
{

	//Q17. Write a program that calculates the simple interest on the principal, 
	//rate of interest and number of years provided by the user. Enter principal, 
	//rate and time through the console using the Scanner class. Interest = Principal* Rate* Time
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// get user input
		System.out.print("Enter principal amount: ");
		double principal = sc.nextDouble();
		sc.nextLine();
		System.out.print("Enter interest rate(%): ");
		double rate = sc.nextDouble();
		sc.nextLine();
		System.out.print("Enter time in years: ");
		double years = sc.nextDouble();
		sc.nextLine();
		System.out.println("Total interest: " + Interest17.getInterest(principal,rate,years));
		
		//exiting programming
		sc.close();
	}

	static double getInterest(double _principal, double _rate, double _years)
	{
		return _principal * _rate * _years;
	}

}
