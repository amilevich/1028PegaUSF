package com.example.palindrome;

import java.util.Scanner;

public class MyClass {

	
	/*
	 * palindrome - "madam", "racecar", "otto", "tacocat"
	 * A user will input a word, your task is to let the user know if his/her word is a palindrome or not. 
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a string to check if it is" + " a palindrome or not");
		String value = sc.nextLine();
		
		String reversed = reverseString(value);
		
		if(reversed.equals(value)) {
			// == -> this compares the memory location
			//.equals -> checks for actual values
			System.out.println("The word is Palindrome");
		} else {
			System.out.println("The word is not Palindrome");
		}
	}

	protected static String reverseString(String value) {
		String temp = "";
		for(int i = value.length()-1; i>=0; i--) {
			temp += value.charAt(i);
		}
		return temp;
	}

}
