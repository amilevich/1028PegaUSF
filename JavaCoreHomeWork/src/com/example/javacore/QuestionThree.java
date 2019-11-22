package com.example.javacore;

import java.util.Scanner;

/*
 *  Reverse a string without using a temporary variable. 
 *   Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
 */
public class QuestionThree {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the string you want to reverse:");
		String input = scan.nextLine();


		byte[] byteConv = input.getBytes();

		byte[] reversed = new byte[byteConv.length];

		// Storing the output in reverse order

		for (int i = 0; i < byteConv.length; i++)
			reversed[i] = byteConv[byteConv.length - i - 1];
		System.out.println();
		System.out.println("This is your string in a reversed order:");
		System.out.println(new String(reversed));


	}

}
