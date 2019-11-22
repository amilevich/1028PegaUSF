package com.questions.homework;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample_8 {
	
	public static void main(String[] args) {
		
		List<String> palindromeList = new ArrayList<String>();
		List<String> wordList = new ArrayList<String>();
		wordList.add("karan");
		wordList.add("madam");
		wordList.add("tom");
		wordList.add("civic");
		wordList.add("radar");
		wordList.add("sexes");
		wordList.add("jimmy");
		wordList.add("kayak");
		wordList.add("john");
		wordList.add("refer");
		wordList.add("billy");
		wordList.add("did");
	
		for(int i = 0; i < wordList.size(); i++) {
			String word = wordList.get(i);
			String reversed = reverseStringTest(word);
			
			if(reversed.equals(word)) {
				//System.out.println("Add this to palindrome.");
				palindromeList.add(word);
				wordList.remove(i);
			}else {
				//System.out.println("Keep in original arraylist");
			}
		}
		System.out.println(palindromeList);
	}
		
		protected static String reverseStringTest(String word) {
			String temp = "";
			for(int i = word.length()-1; i>=0; i--) {
				temp += word.charAt(i);
			}
			return temp;
		}
	}
	
