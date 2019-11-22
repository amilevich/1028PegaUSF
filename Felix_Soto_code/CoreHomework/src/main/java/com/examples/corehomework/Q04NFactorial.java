package com.examples.corehomework;

import java.util.Scanner;

public class Q04NFactorial {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter a number");
		int n = sc.nextInt(); 
		int p = n;
		int f = 1;		
		while (n != 0) {
			f = f * n; 
			n = n - 1;
		}
		System.out.println("The factorial of " + p + " is: " + f);
	}
}