package com.examples.corehomework;

import java.util.Scanner;

public class Q05StrAndIdx {

	static String substring(String str, int idx) {

		if (idx > str.length()) {
			return str;
		}

		String sub = "";

		for (int i = 0; i < idx; i++) {
			sub += str.charAt(i);

		}

		return sub;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a word or a sentence. Preferably a long one");
		String input = sc.nextLine();

		System.out.println("Original String: " + input);

		System.out.println("substring(string, 4): " + substring(input, 4));

		System.out.println("substring(string, 2): " + substring(input, 2));

		System.out.println("substring(string, 10): " + substring(input, 10));

		System.out.println("substring(string,8): " + substring(input, 8));
	}
}