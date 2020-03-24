package com.example.core;
//DONE
/*
 * Reverse a string without using a temporary variable. 
 * Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
 * 
 */
public class Q3 {

	public static void main(String[] args) {
		String stringIn = "Hello";
		System.out.println(reverseString(stringIn));
		
		stringIn = "Goodbye";
		System.out.println(reverseString(stringIn));
		
		stringIn = "G";
		System.out.println(reverseString(stringIn));
		
		stringIn = "Go";
		System.out.println(reverseString(stringIn));
	
	}

	public static String reverseString(String a) {
		for (int j = a.length() - 1; j >= 0; j--) {
			a += a.charAt(j);
		}
	
		for (int j = 0; j < a.length(); j++) {
			a = a.substring(1);
		}
		return a;
	}
}
