package com.example.stringstuff;

public class MyClass {

	public static void main(String[] args) {
		
		String test = "Encyclopedia";
		CharSequence seq = "op";
		boolean bool = test.contains(seq);
		System.out.println("Found the sequence? " + bool);
		
		String str = "This is a sentence... also flying spiders";
		int firstIndex = str.indexOf('h');
		System.out.println("First occurrence char 'y' " + "is at index: " + firstIndex);
		
		int char_at = str.charAt(0);
		System.out.println(char_at);
	}

}
