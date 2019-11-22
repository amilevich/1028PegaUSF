package com.questions.homework;

public abstract class AbstractExample_18B {
	static String word = "ReAlLy BiG wOrD";
	public static void main(String[] args) {
		
		System.out.println(lower(word));

	}
	char charPos;
	boolean hasUpper = false;
	String n = "300";
	
	public boolean upper(String result) {
		for(int i = 0; i < word.length(); i++) { //Go through string length, check chars at each index for Capitol letters
			charPos = word.charAt(i);
			if(Character.isUpperCase(charPos)) {
				hasUpper = true;
			}
		}
		System.out.println(upper(word));
		return hasUpper;
	}
	public static String lower(String upper) {//replace all lowercases with upper cases
		return upper.replaceAll("[A-Z]+", "")+upper.replaceAll("[^A-Z]+", "");
		
	}
	public void integer() {
		int i = Integer.parseInt(n);// Convert "300" from string to int value
		System.out.println(i+50);// int ref of "300" string + int of 50 = 350
	}

}

//Convert the input string to integer and add 10, output the result to the console.
