package com.example.homework;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Q14 {

	// Write a program that demonstrates the switch case. Implement the following functionalities in the cases:
	// Case 1: Find the square root of a number using the Math class method. 
	// Case 2: Display today’s date.
	// Case 3: Split the following string and store it in a string array. 
	//			“I am learning Core Java”

	public void switchCase(int i) {
		System.out.println("");
		// Format date
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String splitMe = "I am learning Core Java";
		
		double squareRoot = 144;
		
		switch(i) {
		case 1:
			System.out.println("The sqaure root of 144 is " + Math.sqrt(squareRoot));
			break;
		case 2:
			System.out.println("Today's Date is " + dateFormat.format(date));
			break;
		case 3:
			@SuppressWarnings("unused") String[] splitArray = splitMe.split(" ");
			break;
		}

		
	}
	
}
