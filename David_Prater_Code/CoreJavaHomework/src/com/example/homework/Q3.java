package com.example.homework;

public class Q3 {

	// Reverse a string without using a temporary variable. Do NOT use reverse() in
	// the StringBuffer or the StringBuilder APIs.

	public void reverseString(String reverseString) {
		// Format Answer
		System.out.println("");

		// Get length of string
		int stringLength = reverseString.length();

		// Starting at the last index of the char array print the character
		for (int i = stringLength - 1; i >= 0; i--) {
			System.out.print(reverseString.charAt(i));
		}

	}

}
