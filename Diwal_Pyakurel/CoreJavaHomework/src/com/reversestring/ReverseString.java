package com.reversestring;

public class ReverseString {
	
	String name = "Diwal";
	String name2= "DiwalP";

	public static void main(String[] args) {
		System.out.println(reverseString("Di"));
		

	}
	
	public static String reverseString(String test) {
	
		for(int i=test.length()-1; i>=0; i--) {
			//adding the character from the last to the end of string
			test+=test.charAt(i);
		}
		//using substring to compare the half of the string using substring with main string
		test=test.substring(test.length()/2);
		return test;
	}
	
	

}
