package com.Q5;

public class Q5 {
	
	// Q5. Write a substring method that accepts a string str and an integer idx and returns the substring contained between 0 and idx-1 inclusive.  Do NOT use any of the existing substring methods in the String, StringBuilder, or StringBuffer APIs.
	
		 static void substring (String str , int idx) {
			 char[] stringToCharArray = str.toCharArray();
			 System.out.print("Substring Method: ");
		     for (int i=0; i<idx-1; i++) { 
					System.out.print(stringToCharArray[i]);
			 }
		     System.out.println();
		 }
	
	public static void main(String[] args) {
		String input = "This is an amazing life";
		substring(input, 4);
	} 
}
