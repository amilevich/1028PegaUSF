package com.Q3;

public class Q3 {
	//Q3. Reverse a string without using a temporary variable.  Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.

		 protected static String reverseString(String input) {
			 char[] try1 = input.toCharArray(); 
			 String reverse = "";
		        for (int i = try1.length-1; i>=0; i--) 
		            reverse = reverse + try1[i]; 
		     return reverse;   
		    
		    } 
	public static void main(String[] args) {
		String input = "This is an amazing life";
		System.out.println("Reverse String: "+ reverseString(input));
		
	}
}
