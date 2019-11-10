package com.example.core;

import java.util.Scanner;

/*
 * Write a program to display the number of characters for a string input.
 * The string should be entered as a command line argument 
 * using (String [ ] args).
 */
//TO DO: double check question requirement 
public class StringLenQ16 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String temp = sc.next();
		System.out.println(temp.length());
	}

}
