package com.homework.algorthim;

public class Q5SubString {
	
	//Q5. Write a substring method that accepts a string str and an integer idx and returns the substring contained between 0 and idx-1 inclusive.  Do NOT use any of the existing substring methods in the String, StringBuilder, or StringBuffer APIs.
	
	public String subString(String str, int idx) {
		char[] string = new char[idx];
		
		for(int i =0; i< idx-1; i++) {
			string[i] =str.charAt(i); 
		}
		
		String newString = new String(string);
		return newString;
	}
	
	

}