package com.example.core;

import java.util.Scanner;

/*
 * Write a program to display the number of characters for a string input.
 * The string should be entered as a command line argument 
 * using (String [ ] args).
 */
//TO DO: double check question requirement 
public class Q16 {

	public static void main(String[] args) {
		int characters = 0;
		if (args.length > 0) {
			for (String i : args) {
				characters++;
			}
		}
		System.out.println("There are " + characters + " characters in the string passed in");
	}

}
