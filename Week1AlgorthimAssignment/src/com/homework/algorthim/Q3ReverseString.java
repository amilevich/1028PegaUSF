package com.homework.algorthim;

public class Q3ReverseString {
	
	
	public void reverseString(String input) {
		
		//Attempt 1
		for(int i = input.length()-1; i >= 0; i--) {
			input+=input.charAt(i);
		}
		System.out.println(input);

		for(int j = 0; j < input.length() ; j++) {
			input = input.substring(1, (input.length()));
			//input = input.substring(j, (input.length()));
			System.out.println(j + " " + input);
		}
		//System.out.println(input);
		
		
	}

}
