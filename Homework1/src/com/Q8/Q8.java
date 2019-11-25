package com.Q8;

import java.util.ArrayList;
import java.util.Arrays;

import com.Q3.Q3;

public class Q8 extends Q3{
	//Q8. Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList.
	 
		 static ArrayList<String> palindrome(String [] pal) {
			 ArrayList<String> names = new ArrayList<String>(Arrays.asList(pal));
			 ArrayList<String> reversedArrayList = new ArrayList<String>();
			 System.out.println("Original List: "+ names);
			 //System.out.print(names.get(3));
			 int i = 0;
			 // inputs each element in the initial array list  
			 // into reverseString Method, returns a string reversed 
			 System.out.print("Reversed Array List: ");
			 while(i < names.size()) {
				 String reverse = reverseString(names.get(i));
				 if(reverse.equals(names.get(i))) {
					 //reverse = reverseString(names.get(i)); 
					 reversedArrayList.add(names.get(i));
				 }
				 i++;	
			 }
			 return reversedArrayList;
			 
		 }
	public static void main(String[] args) {
		String [] pal = {"karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john",  "refer", "billy", "did"};
		System.out.println(palindrome(pal));
	}
}
