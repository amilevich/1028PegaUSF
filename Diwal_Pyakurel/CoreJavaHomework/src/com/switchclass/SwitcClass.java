package com.switchclass;

import java.time.LocalDate;
import java.util.Scanner;

public class SwitcClass {
	
	
	
	
	public static void main(String[] args) {
		
		while(true) {
			getSwitch();
		}
		
		
	}
	
	public static void getSwitch() {
		
		System.out.println("Type 1: For finding square root");
		System.out.println("Type 2: To get current date");
		System.out.println("Type 3: To split array");
		
		Scanner sc = new Scanner(System.in);
		String userResponse = sc.nextLine();
		
		switch(userResponse) {
		case "1":
			System.out.println("Please provide a number to find square root");
			double number = sc.nextDouble();
			System.out.println(Math.sqrt(number));
			break;
		case "2":
			LocalDate ld = LocalDate.now();
			System.out.println(ld);
			break;
		case "3":
			String sentence = "I am learning Core Java";
			String[] ar = sentence.split(" ");
			for(int i = 0; i<ar.length; i++) {
				System.out.println(ar[i]);
			}
			break;
		default:
			System.out.println("Invalid response");
		
		}
		
		
	}

}
