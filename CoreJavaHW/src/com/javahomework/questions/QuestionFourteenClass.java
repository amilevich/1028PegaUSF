package com.javahomework.questions;

import java.util.Date;
import java.util.Scanner;

public class QuestionFourteenClass {
	public static void main(String[] args) {
		/*
		 * Write a program that demonstrates the switch case. Implement the following functionalities in the cases:
			Case 1: Find the square root of a number using the Math class method. 
			Case 2: Display today’s date.
			Case 3: Split the following string and store it in a string array. 
		“I am learning Core Java”
		 * */
		Scanner sc = new Scanner(System.in);
		int opt;
		
		System.out.println("CHOOSE WHICH EVER ONE YOU WOULD LIKE TO CHOOSE:");
		System.out.println("1: Find the square root of a number using math class");
		System.out.println("2: Display today's date");
		System.out.println("3: Split the following string and store it in a string array");
		System.out.print("Enter option here:  ");
		opt = sc.nextInt();
		switch(opt) { // switch is on and when the option is chosen
			
		case 1://in the case that user choses one then we print out the swuare root
			System.out.println("enter the number to find the square root ");
			int c = (int) Math.sqrt(sc.nextInt());
			System.out.println(c);
			break;
		case 2://in the case that user choses two then we print out today's date
			System.out.println("here is today's date: ");
			Date d = new Date();
			System.out.println(d);
			break;
		case 3:// in the case that user choses three then split string and store in array
			String s1= "I Am learing Core Java";

		       String[]  array = s1.split(" ");
		       for(int i=0;i<array.length;i++)
		       {
		           System.out.println(array[i]);
		       }
			break;
		}
	}
}
