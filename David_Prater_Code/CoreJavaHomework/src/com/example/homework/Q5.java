package com.example.homework;

public class Q5 {

	// Write a substring method that accepts a string str and an integer idx and
	// returns the substring contained between 0 and idx-1 inclusive. Do NOT use any
	// of the existing substring methods in the String, StringBuilder, or
	// StringBuffer APIs.
	
	public void subString(String string, int index) {
		
		// Print the characters from 0 to specified index
		for(int i = 0; i <= index; i++) {
			System.out.print(string.charAt(i));
		}
		
	}

}
