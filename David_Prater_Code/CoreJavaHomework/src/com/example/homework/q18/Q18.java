package com.example.homework.q18;

public class Q18 implements Q18Interface {

	// Q18. Write a program having a concrete subclass that inherits three abstract
	// methods from a
	// superclass. Provide the following three implementations in the subclass
	// corresponding to the abstract methods in the superclass:

	// 1. Check for uppercase characters in a string, and return ‘true’ or ‘false’
	// depending if any are found.
	// 2. Convert all of the lower case characters to uppercase in the input string,
	// and return the result.
	// 3. Convert the input string to integer and add 10, output the result to the
	// console.
	
	
	public void question18() {
		containsUpperCase("Apple");
		toLowerCase("AsDfG");
		convertString("156");
		
	}

	@Override
	public boolean containsUpperCase(String s) {
		char[] charArray = s.toCharArray();
		for (char c : charArray) {
			if (Character.isUpperCase(c)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public String toLowerCase(String s) {

		return s.toUpperCase();
	}

	@Override
	public void convertString(String s) {
		int convertedString = Integer.parseInt(s) + 10;
		System.out.println(convertedString);

	}

}
