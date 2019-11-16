package com.assignment1;

import java.util.Scanner;

public class SubstringMethodHwk {
	
	public static String substring(String newString,int idx) {
		
		String returnString = "";
		
		for (int i =0;i<idx;i++) {
			returnString = returnString + newString.charAt(i);
		}
		return returnString;
	}
	
	public static void dealingWithTheUser() {
		Scanner in = new Scanner(System.in);
		System.out.println("Write a word or phrase.");
		String newString = in.nextLine();
		System.out.println("Write an index, within the scope your phrase or this doesn't work. If you wanted error handling you'd have to set me 19 less questions.");
		int idx = in.nextInt();
		String newSubstring = substring(newString,idx);
		System.out.println(newSubstring);
		System.out.println("Thanks for not breaking my code.");
		in.close();
	}

	public static void main(String[] args) {
		
		dealingWithTheUser();

	}

}
