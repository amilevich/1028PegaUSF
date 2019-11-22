package com.example.simpleinterest;

import java.util.Scanner;

public class SimpleInterest {

	public static void main(String[] args) {
		float principal, rate, time;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Calculation the Simple interest, \nPlease enter principal: ");
		principal = sc.nextFloat();
		
		System.out.println("Please enter rate: ");
		rate = sc.nextFloat();
		
		System.out.println("Please enter time: ");
		time = sc.nextFloat();
		
		System.out.println("Your simple interest is: " + principal*rate*time);
	
		
        sc.close();   
	}

}
