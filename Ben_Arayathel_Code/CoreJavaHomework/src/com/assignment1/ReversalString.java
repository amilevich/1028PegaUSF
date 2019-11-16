package com.assignment1;

import java.util.Scanner;

public class ReversalString {
	
	public static void Reverse() {
		System.out.println("Write a word or phrase you would like to be reversed.");
		Scanner in = new Scanner(System.in);
		
		String newString = in.nextLine();
		
		for (int i = 0; i < newString.length(); i++) {
		    newString = newString.substring(1, newString.length() - i) //the portion of the string to be reversed.
		        + newString.substring(0, 1) //the string is switched around to the ith position 
		        + newString.substring(newString.length() - i, newString.length()); //the reversed part of the string is then added
		 }
		System.out.println(newString);
		
		System.out.println("This product could not have been developed without the help of the internet");
		
		in.close();
		
	}
	
	public static void main(String[] args) {
		
		Reverse();
		
	}

}
