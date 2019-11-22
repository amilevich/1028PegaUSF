package com.homework.algorthim;

import java.util.Scanner;

public class Q17Interest {
	
	public void interest() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Principal");
		double principal = input.nextDouble();
		System.out.println("Rate is 8.25%");
		double rate = .0825;
		System.out.println("How many years have you been here?");
		double time = input.nextDouble();
		double interest = principal*rate*time;
		System.out.println("This is your total interest foo: "+interest);
		System.out.println("Total balance: " + (principal+interest));
		
		
	}

}
