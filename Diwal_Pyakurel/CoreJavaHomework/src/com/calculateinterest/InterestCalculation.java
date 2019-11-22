package com.calculateinterest;

import java.util.Scanner;

public class InterestCalculation {
	
	
	public static void main(String[] args) {
		float interest = calculateInterest();
		System.out.println(interest);
	}
	
	public static float calculateInterest() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please provide the prinicpal amount");
		float principal = sc.nextFloat();
		System.out.println("Please provide the interest rate. Ignore %");
		float percentage = sc.nextFloat();
		System.out.println("Please provide the number of years");
		float year = sc.nextFloat();
		
		float interest = principal*percentage*year/100;
		
		return interest;
		
		
	}

}
