package com.examples.corehomework;

import java.util.Scanner;

public class Q17Interest {

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
		
		interest = principal * rate * time; 
		System.out.println("This is your interest: ");
		System.out.println(interest);
	}
}