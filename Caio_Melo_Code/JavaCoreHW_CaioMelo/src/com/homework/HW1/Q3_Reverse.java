package com.homework.HW1;
//Reverse string without using temp variables or reverse() method;
public class Q3_Reverse {

public static void main(String[] args) {
	
	String test = "Java is pretty cool";
	
	reverse(test);
}
	
	public static void reverse(String input) {
		System.out.println("Printing Reversed String...");
		for(int i = input.length() - 1;i>=0;i--) { //Start at length of string - 1, and decrement until 0
			
			System.out.print(input.substring(i,i+1)); //index of i into substring to print last char
		
			
		}
	}
	
	
}
