package com.homework.qfourteen;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Qfourteen {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int temp;
		System.out.println("Here are your options: ");
		System.out.println("1 Square root of number");
		System.out.println("2 Today's date");
		System.out.println("3 String splitter");
		System.out.print("Which one ya feeling today: ");
		temp = sc.nextInt();
		
		switch (temp) {
		case 1:
			System.out.print("Give me a number: ");
			temp = sc.nextInt();
			System.out.println(Math.sqrt(temp));
			break;
		case 2:
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			break;
		case 3:
			System.out.println("Original string: I am learning Core Java");
			String toBeSplit = "I am learning Core Java";
			String[] split = toBeSplit.split(" ", 5);
			for (String spl : split) {
			System.out.println("Split string: " + spl);
			}//finish later
			break;
		default: 
			System.out.println("Not a valid option.  Try again later.");
		}

	}

}
