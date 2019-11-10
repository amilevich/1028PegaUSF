package com.example.core;

import java.util.ArrayList;
//DONE
/*
 * Write a program that stores the following strings in an
 * ArrayList and saves all the palindromes in another ArrayList.
“karan”, “madam”, ”tom”, “civic”, “radar”, “sexes”, “jimmy”,
 “kayak”, “john”,  “refer”, “billy”, “did”
 */
public class ArrayListsQ8 {

	public static ArrayList<String> notPalindrome = new ArrayList<String>();
	public static ArrayList<String> palindrome = new ArrayList<String>();

	public static void main(String[] args) {

		String str[] = { "karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy",
				"did" };
		listSeparation(str);
		System.out.println(notPalindrome);
		System.out.println(palindrome);

	}

	public static void listSeparation(String[] check) {

		for (int i = 0; i < check.length; i++) {
			if (isPalindrome(check[i])) {
				palindrome.add(check[i]);
			} else {
				notPalindrome.add(check[i]);
			}
		}
	}

	public static boolean isPalindrome(String str2) {
		boolean yes = true;
		for (int i = 0; i < (str2.length() / 2); i++) {
			if ((str2.charAt(i)) == str2.charAt((str2.length()) - 1 - i)) {
				yes = true;
			} else {
				yes = false;
				break;
			}
		}
		return yes;
	}

}
