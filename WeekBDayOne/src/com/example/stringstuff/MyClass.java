package com.example.stringstuff;

public class MyClass {

	public static void main(String[] args) {

		String test = "Encyclopepia";
		CharSequence seq = "op";
		boolean bool = test.contains(seq);
		System.out.println("Found the sequence? " + bool);
		
		String str = "This is a sentence... also flying spiders";
		//return an index of the first occurrence of the letter "h"
		
		int firstIndex = str.indexOf('h');
		System.out.println("First occurrence of char 'h' is at index: " + firstIndex);
		
		//gives SCII value of character at index 0
		int char_at = str.charAt(0);
		System.out.println(char_at);
	}

}
