package com.homework.Q3;

import java.util.Scanner;

public class StringReverse {

	public static void main(String[] args) {
		String name;
		String name1 = "";
		
		Scanner info = new Scanner(System.in);
		
		System.out.println("Please enter a word: ");
		 name = info.nextLine();
		 
		 // runs through the array from the nd to the begin
		 for(int i = name.length() - 1; i >= 0; i--)
	        {
			 	//  stores each character in the new string
	            name1 = name1 + name.charAt(i);
	        }
		
		System.out.println("Reverse: " + name1);

	}

}
