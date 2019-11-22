package com.example.javacore;

import java.util.Scanner;
/*
 * Write a substring method that accepts a string str 
 * and an integer idx and returns the substring contained 
 * between 0 and idx-1 inclusive.  Do NOT use any of the existing 
 * substring methods in the String, StringBuilder, or StringBuffer APIs.
 */
public class QuestionFive {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a long string.");
		String input = scan.nextLine();

		System.out.println("String: " + input);

		System.out.println("substring(string, 4): " + substring(input, 4));

		System.out.println("substring(string, 2): " + substring(input, 2));

		System.out.println("substring(string, 10): " + substring(input, 10));

		System.out.println("substring(string,8): " + substring(input, 8));
		

	}
	// substring method
	static String substring(String str, int idx) {

		if (idx > str.length()) {
			return str;
		}

		String sub = "";

		for (int i = 0; i < idx; i++) {
			sub += str.charAt(i);

		}

		return sub;// returning substring

	}// end substring method

}// end class
