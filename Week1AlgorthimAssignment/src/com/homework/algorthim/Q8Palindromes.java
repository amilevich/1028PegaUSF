package com.homework.algorthim;

import java.util.ArrayList;

public class Q8Palindromes {

	// “karan”, “madam”, ”tom”, “civic”, “radar”, “sexes”, “jimmy”, “kayak”, “john”,
	// “refer”, “billy”, “did”
	// populate arrayList with names
	ArrayList<String> list = new ArrayList<String>();
	ArrayList<String> nopalindromes = new ArrayList<String>();
	ArrayList<String> palindromes = new ArrayList<String>();

	public void arrayList() {

		list.add("karan");
		list.add("madam");
		list.add("tom");
		list.add("civic");
		list.add("radar");
		list.add("sexes");
		list.add("jimmy");
		list.add("kayak");
		list.add("john");
		list.add("refer");
		list.add("billy");
		list.add("did");
		System.out.println("This is the orginal arraylist of strings: " + list);

		for (String i : list) {
			boolean pal = isPalindrome(i);

			if (pal) {
				palindromes.add(i);
			} else {
				nopalindromes.add(i);
			}
		}
		
		System.out.println(palindromes);
		System.out.println(nopalindromes);

	}

	public static boolean isPalindrome(String input) {
		if (input == null || input.isEmpty())
			return false;

		return new StringBuilder(input).reverse().toString().equals(input);
	}

}

// name.add("karan");
// name.add("madam");
// name.add("tom");
// name.add("civic");
// name.add("radar");
// name.add("sexes");
// name.add("jimmy");
// name.add("kayak");
// name.add("john");
// name.add("refer");
// name.add("billy");
// name.add("did");
// System.out.println("This is the orginal arraylist of strings: "+name);
//
// //Check for Palindromes
// String reverse;
// for(String i : name) {
// reverse = reverse + i.
// }

// iterate through object and check if object is a palindrome
// push palindrome into new arraylist
