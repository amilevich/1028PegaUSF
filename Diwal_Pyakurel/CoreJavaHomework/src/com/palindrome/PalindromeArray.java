package com.palindrome;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class PalindromeArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String arr[] = { "karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy",
				"did" };
		getPalindrome(arr);
	}

	public static void getPalindrome(String[] arr) {
		ArrayList<String> palindromeWord = new ArrayList<>();
		ArrayList<String> arrList = new ArrayList<>();
		//adding the array in arraylist
		for (int i = 0; i < arr.length; i++) {
			arrList.add(arr[i]);
		}
		//
		for (int i = 0; i < arrList.size(); i++) {
			String temp = "";
			for (int j = arrList.get(i).length() - 1; j >= 0; j--) {
				//adds the character in temposrary string
				temp += arrList.get(i).charAt(j);
			}

			if (temp.equals(arrList.get(i))) {
				//compares the temp with palindrome word and will add in the arraylist
				palindromeWord.add(temp);
			}

		}
		System.out.println(palindromeWord);
		

	}

}
