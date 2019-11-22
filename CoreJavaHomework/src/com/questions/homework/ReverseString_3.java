package com.questions.homework;

public class ReverseString_3 {

	public static void main(String[] args) {
		
		String reverse = "Reverse String";
		
		int letters = reverse.length();// get string length, start from end of string and grab chars in reverse
		for(int i = (letters - 1); i >= 0; --i) {
			reverse += reverse.charAt(i);
		}
		
		reverse = reverse.substring(letters);//turn those chars in order to print in reverse
		
		System.out.println(reverse);
	}
}
