package com.homework.qeight;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Qeight {

	public static void main(String[] args) {
		ArrayList<String> palindrome = new ArrayList();
		ArrayList<String> palindromeRev = new ArrayList();
		ArrayList<String> isPalindrome = new ArrayList();

		String[] palindromeList = { "karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john",
				"refer", "billy", "did" };
		// adds to palindrome ArrayList
		for (int i = 0; i < palindromeList.length; i++) {
			palindrome.add(palindromeList[i]);
		}
		// adds to palindrome ArrayList and reverses the strings
		for (int j = 0; j < palindromeList.length; j++) {
			palindromeRev.add(reverseString(palindromeList[j]));
		}
		//creates iterators
		ListIterator<String> palIterator = palindrome.listIterator();
		ListIterator<String> revIterator = palindromeRev.listIterator();
		
		//checks to see if it is a palindrome
		while (palIterator.hasNext() && revIterator.hasNext()) {
			String temp = palIterator.next();
			String temp2 = revIterator.next();
			//is a palindrome
			if (temp.equals(temp2)) {
				isPalindrome.add(temp);
			}

		}
		//prints out array list of all words tested
		System.out.println(palindrome);
		//prints out array list of all palindromes
		System.out.println(isPalindrome);
	}

	protected static String reverseString(String value) {
		String temp = "";
		for (int i = value.length() - 1; i >= 0; i--) {
			temp += value.charAt(i);
		}
		return temp;
	}

}
