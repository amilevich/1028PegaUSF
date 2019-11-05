package com.example.stringstuff;

public class MyClass {

	public static void main(String[] args) {
		
		String test = "Encyclopedia";
		CharSequence seq = "apple";
		boolean bool = test.contains(seq);
		System.out.println("Found the sequence? " + bool);
		
		String str = "This is a sentence... also flying spiders";
		//return an index of the first occurrence of letter "h"
		int firstIndex = str.indexOf('y');
		System.out.println("First occurrence of char 'y'"
				+ " is at index: " + firstIndex);
		
		int char_at = str.charAt(0);
		//gives ASCII value of character at index 0
		System.out.println(char_at);
	}

}
