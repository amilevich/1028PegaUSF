package com.example.core;
//DONE
/*
 * Write a substring method that accepts a string str 
 * and an integer idx and returns the substring contained
 * between 0 and idx-1 inclusive.  Do NOT use any of the 
 * existing substring methods in the String, StringBuilder, 
 * or StringBuffer APIs
 */
public class SubstringQ5 {

	public static void main(String[] args) {

		String str = "hamburger";
		int n = 2;
		System.out.println(subString(str, n));
		System.out.println(subString(str, 4));
		System.out.println(subString(str, 8));

	}

	public static String subString(String str, int n) {
		String temp = "";
		for (int i = 0; i < n; i++) {
			temp += str.charAt(i);
		}
		return temp;
	}

}
