package com.examplestringstuff;

public class MyClass {

	public static void main(String[] args) {

		/*
		 * we have a string class but all strings are objects
		 */
		
		String test = "SAdie";
		CharSequence seq = "ad";
		boolean bool = test.contains(seq);
		System.out.println("Found the sequence? " + bool);
		
		String sent = "This is a sentence... also boo";
		//return the index of the first occurence of letter h
		int firstIndex = sent.indexOf('i');
		System.out.println("First occurence of char 'i' is at index " + firstIndex);
		
		int char_at = sent.charAt(0);
		System.out.println(char_at); //84 was printed because T is ascii value 84
	}

}
