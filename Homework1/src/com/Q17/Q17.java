package com.Q17;

import java.util.Scanner;

public class Q17 {

	public static void main(String[] args) {
		//Q17 Interest Rate Calculator
		 
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your principal ,int rate and term length :");
		double principal = sc.nextInt();
		double rate = sc.nextInt();
		double term_length = sc.nextInt();
		
		
		System.out.println("The simple interest on $"+principal+", at a rate of "+rate+"%, for a term of "+ term_length+
				" years is: $"+principal*rate* term_length/100);
		

	}

}
