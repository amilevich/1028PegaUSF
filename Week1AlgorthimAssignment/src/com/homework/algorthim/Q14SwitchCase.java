package com.homework.algorthim;

import java.sql.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Q14SwitchCase {
	//Q14. Write a program that demonstrates the switch case. Implement the following functionalities in the cases:
//	Case 1: Find the square root of a number using the Math class method. 
//	Case 2: Display today’s date.
//	Case 3: Split the following string and store it in a string array. 
//			“I am learning Core Java
	
	public void switchCase() {
		
		
		System.out.println("1. Square Root \n 2. Display date \n 3. Store String");
		Scanner input = new Scanner(System.in);
		int option = input.nextInt();
		
		switch(option) {
		case 1 :
			System.out.println("Enter number to find its Square Root:");
			int inputs = input.nextInt();
			double answer = Math.sqrt(inputs);
			System.out.println(answer);	
			break;
		case 2 :
			System.out.println("Display todays date");
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			break;
		case 3 : 
			System.out.println("[I am learning Core Java]");

            			
		default:
			System.out.println("Default");
		}
	}

}