package com.example.homework;

import java.util.ArrayList;
//import java.util.Iterator;

public class Q8 {

	// Q8. Write a program that stores the following strings in an ArrayList and
	// saves all the palindromes in another ArrayList. “karan”, “madam”, ”tom”,
	// “civic”, “radar”, “sexes”, “jimmy”, “kayak”, “john”, “refer”, “billy”, “did”
	
	public void palindromeCheck() {
		ArrayList<String> wordList = new ArrayList<String>();
		ArrayList<String> palindromes = new ArrayList<String>();
		wordList.add("karan");
		wordList.add("madam");
		wordList.add("tom");
		wordList.add("civic");
		wordList.add("radar");
		wordList.add("sexes");
		wordList.add("jimmy");
		wordList.add("kayak");
		wordList.add("jon");
		wordList.add("refer");
		wordList.add("billy");
		wordList.add("did");
		

		//Iterator itr = wordList.iterator();
		
		for(String s : wordList) {
			String temp = palindrome(s);
			if(temp.equals(s)) {
				palindromes.add(s);
			}
		}
		
		
		
		//System.out.println(wordList.toString());
		System.out.println(palindromes.toString());
		
	}
	
	// Check palindrome
	public static String palindrome(String s) {
		String temp = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			temp+= s.charAt(i);
		}
		return temp;
	}

}
