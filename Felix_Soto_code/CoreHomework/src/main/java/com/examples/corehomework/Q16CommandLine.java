package com.examples.corehomework;

public class Q16CommandLine {
	public static void main(String[] args) {

		if (args.length == 1) {
			System.out.println("This word has " + args[0].length() + " characters");
		}
		else {
			System.out.println("Please enter a valid word");
		}
	}
}