package com.homework.HW1;

/*
 * Displays number of characters for the string input passed to the command line argument.
 */

public class Q16_StringChar {
	public static void main(String[] args) {
		for (String x : args) {
			System.out.println(x.length());
		}
	}
}
