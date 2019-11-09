package com.examplepalindrome;

import java.util.Scanner;

public class MyClass {
	
	/*
	 * Palindrome - are words that you can read back and forth and have the same meaning
	 * 
	 * Ex: "madam", "racecar", "otto", tacocat"
	 * 
	 * your task is to let the user know if his/her word is a palidrome or not
	 */

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a string to check if it is a palidrome or not");
		String value = sc.nextLine();
		String reversed = reverseString(value);
		
		if(reversed.equals(value)) {
			//== -> compares memory locations
			//.equals -> compare actual value
			
			System.out.println("The word is a palidrome");
		}
		else {
			System.out.println("Not a palidrome");
		}
		
	}
	
	protected static String reverseString(String value) {
		
//		for(int i = 0; i < value.length(); i++) {
//			
//			for(int j = value.length() -1; j > 0; j--) {
//				
//				if(value.charAt(i) == value.charAt(j)) {
//					
//				}
//			}
//		}
		
		String temp = "";
		for(int i = value.length() -1; i >= 0; i--) {
			temp += value.charAt(i);
		}
		return temp;
		
	}

}
