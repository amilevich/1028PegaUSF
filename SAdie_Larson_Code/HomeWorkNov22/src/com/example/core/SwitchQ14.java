package com.example.core;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Write a program that demonstrates the switch case.
 *  Implement the following functionalities in the cases:
Case 1: Find the square root of a number using the Math class method. 
Case 2: Display today’s date.
Case 3: Split the following string and store it in a string array. 
		“I am learning Core Java”
 */
//CHECK does she mean char array?
//like literally November 22 or using some access?
public class SwitchQ14 {

	public static void main(String[] args) {

		int cases = 3;
		while (cases > 0) {
			System.out.println("Showing case: " + cases);
			switch (cases) {
			case 1:
				int n = 9;
				System.out.println(Math.sqrt(n));
				break;
			case 2:
				DateFormat dateForm = new SimpleDateFormat("MM/dd/yyy");
				Date date = new Date();
				System.out.println(dateForm.format(date));
				break;
			case 3:
				String str = "I am learning Core Java";
				char arr[] = str.toCharArray();
				for (char i : arr) {
					System.out.println(i);
				}
				break;
			}
			cases--;
			System.out.println("---------------------");
		}
	}

}
