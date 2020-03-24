package com.example.palindrome;

import java.util.Scanner;

public class MyClass {

	public static void main(String[] args) {

		/*
		 * palindrome - "madam", "racecar", "otto"
		 * a user will iput a word
		 * your task is to let the user  know if his/her word is a 
		 * palindorme or not
		 */
		//my code
//		while (true) {
//			System.out.println("Please enter a word: ");
//			Scanner sc = new Scanner(System.in);
//			String pal = sc.nextLine();
//			boolean isAPalindrome = true;
//			for (int i = 0; i <= (((pal.length()) / 2 ) - 1); i++) {
//				if (pal.charAt(i) != pal.charAt((pal.length()) - i -1)) {
//					isAPalindrome = false;
//				}
//			}
//			if( pal.length() <= 2) {
//				isAPalindrome = false;
//			}
//			if (isAPalindrome) {
//				System.out.println("Yay, it is a palindrome");
//			} else {
//				System.out.println("BOo, it is not a palindrome");
//			}
//		
	Scanner sc  = new Scanner(System.in);
	String value = sc.nextLine();
	String reversed = reverseString(value);
	System.out.println(reversed);
	if(reversed.equals(value)) {
		System.out.println("The word is not a palindrome");
	}
	else {
		System.out.println("Not a palindrome");
	}
	}
	
	public static String reverseString(String value) {
		String temp = null;
		for(int i = value.length() - 1; i >=0; i--) {
			temp += value.charAt(i);
		}
		return temp;
	}

}
