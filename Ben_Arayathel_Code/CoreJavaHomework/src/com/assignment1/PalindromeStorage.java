package com.assignment1;

import java.util.ArrayList;
import java.util.List;

public class PalindromeStorage {
	
	public static String Reverse(String newString) {
		
		for (int i = 0; i < newString.length(); i++) {
		    newString = newString.substring(1, newString.length() - i) //the portion of the string to be reversed.
		        + newString.substring(0, 1) //the string is switched around to the ith position 
		        + newString.substring(newString.length() - i, newString.length()); //the reversed part of the string is then added
		 }
		
		return newString;
		
	}
	
	
	public static void main(String[] args) {
		
		
		String[] listOfStrings = {"karan","madam","tom","civic","radar","sexes","jimmy","kayak","john","refer","billy","did"};
		
		List<String> palindromeList = new ArrayList<>();
		List<String> nonPalindromeList = new ArrayList<>();
		
		for(String i:listOfStrings) {
			if(i.equals(Reverse(i))) {
				palindromeList.add(i);
			}else {
				nonPalindromeList.add(i);
			}
			
		}
		
		System.out.println("palindrome list: " + palindromeList);
		System.out.println("nonpalindrome list: " + nonPalindromeList);
		
		
	}

}
