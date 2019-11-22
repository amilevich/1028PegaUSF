package com.substring;

public class SubString {
	public static void main(String[] args) {
		subStr("Apple", 5);
		subStr("Banana", 3);
		subStr("Orange", 1);
		subStr("Dog", 2);
	}
	
	public static void subStr(String word, int n) {
		String temp = "";
		
		for(int i =0; i<n; i++) {
			temp += word.charAt(i);
		}
		
		
		
		System.out.println("The sub string for  " + word+ " is "+ temp);
	}

}
