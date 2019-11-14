package com.assignment1;

import java.util.Scanner;

public class Q17 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Interest");
		double interest = in.nextDouble();
		System.out.println("Years");
		int years = in.nextInt();
		System.out.println();
		long principle = in.nextLong();
		System.out.println(Math.pow(interest, years)*principle);
		
	}
}
