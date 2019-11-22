package com.homework.Q17;

import java.util.Scanner;

public class InterestP {

	public static void main(String[] args) {
		
		Scanner combine = new Scanner(System.in);
		double interest;
		double principal;
		int time;
		double rate;
		
		System.out.println("Please enter principle rate: ");
		principal = combine.nextDouble();
		
	
		System.out.println("Please enter the rate:  ");
		rate = combine.nextDouble();
		
		System.out.println("Please enter the time(years):  ");
		time = combine.nextInt();
		
		// applies the interest for three values
		interest = principal * rate * time; 
		
		System.out.println("Your interest is: " + interest);
	}

}
