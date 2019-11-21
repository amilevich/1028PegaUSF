package com.javahomework.questions;

public class QuestionThreeClass {
	public static void main(String[] args) {
		/*
		 * Reverse a string without using a temporary variable. Do NOT use reverse() in
		 * the StringBuffer or the StringBuilder APIs.
		 */
		String str = " Hello i am superman! "; //here i have my string
		String strArr[] = new String[str.length()]; //here i make a string array with fixed size
		for (int i = 0; i < str.length(); i++) { // i use the forloop to iterate the array
			strArr[i] = String.valueOf(str.charAt(i));//get the value of the string character and store it in array
		}
		//this part is just to print out the reversed string
		System.out.println("String reverse: ");
		for (int b = str.length() - 1; b >= 0; b--) {
			System.out.print(strArr[b]);
		}
	}
}
