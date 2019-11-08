package com.example.palindrome;

import java.util.Scanner;

public class MyClass {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a string to check if it is" + "a palindrome or not");
		String value = sc.nextLine();
		String reversed = ReverseString(value);
		if(reversed.equals(value)) {
			// == -> compares location memory
			// .equals
			System.out.println("the word is palindrome");
		} else {
			System.out.println("the word is not a palindrome");
		}

	}

	protected static String ReverseString(String value) {
		String temp = "";
		for(int i = value.length()-1;i>=0;i--) {
			temp += value.charAt(i);
		}
		return temp;
	}
	

}
