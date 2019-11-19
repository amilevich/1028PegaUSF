package com.homework.HW1;

import java.util.Scanner;

public class Q17_Interest {
public static void main(String[] args) {
	
	Scanner scan = new Scanner(System.in);
	
	System.out.println("Please enter principal loan amount.: ");
	double principal = scan.nextDouble();
	System.out.println("Please enter the interest rate: ");
	double interest = scan.nextDouble();
	System.out.println("Please enter the time period: ");
	double time = scan.nextDouble();
	
	double netInterest = principal*interest*time; //Formula to display simple interest.
	System.out.println("Net Interest: "+ netInterest + " on principal of: "+principal);
	
	
	
}
}