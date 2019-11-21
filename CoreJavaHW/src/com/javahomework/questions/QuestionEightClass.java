package com.javahomework.questions;

import java.util.ArrayList;

public class QuestionEightClass {
	/*
	 * 
	 * Write a program that stores the following strings in an 
	 * ArrayList and saves all the palindromes in another ArrayList.
		“karan”, “madam”, ”tom”, “civic”, “radar”, “sexes”, “jimmy”, 
		“kayak”, “john”,  “refer”, “billy”, “did”

	 * 
	 * */
	
	public static void main(String[] args) {
		////////creating the arrylists that i will need for this excercise
		ArrayList<String>strArr = new ArrayList<String>();
		ArrayList<String>palinArr = new ArrayList<String>();
		///////initializing my string variables before storing in the arraylist
		String n1 = "karan";
		String n2 = "madam";
		String n3 = "tom";
		String n4 = "civic";
		String n5 = "radar";
		String n6 = "sexes";
		String n7 = "jimmy";
		String n8 = "kayak";
		String n9 = "john";
		String n10 = "refer";
		String n11 = "billy";
		String n12 = "did";
		//passing all strings in to the strArr list that takes all strings
		
		strArr.add(n1);
		strArr.add(n2);
		strArr.add(n3);
		strArr.add(n4);
		strArr.add(n5);
		strArr.add(n6);
		strArr.add(n7);
		strArr.add(n8);
		strArr.add(n9);
		strArr.add(n10);
		strArr.add(n11);
		strArr.add(n12);
		///initializing my string variables to the result of the reverse the string
		String reverse1 = reverseString(n1);
		String reverse2 = reverseString(n2);
		String reverse3 = reverseString(n3);
		String reverse4 = reverseString(n4);
		String reverse5 = reverseString(n5);
		String reverse6 = reverseString(n6);
		String reverse7 = reverseString(n7);
		String reverse8 = reverseString(n8);
		String reverse9 = reverseString(n9);
		String reverse10 = reverseString(n10);
		String reverse11 = reverseString(n11);
		String reverse12 = reverseString(n12);
		///creating the conditions that need to be met before storing into the palindrome arraylist
		//all these conditions basically say if it is palindrome store them in an arraylist.
		if(reverse1.equals(n1)) {
			palinArr.add(n1);
		}else {
			strArr.add(n1);
		}
		if(reverse2.equals(n2)) {
			palinArr.add(n2);
		}else {
			strArr.add(n2);
		}
		if(reverse3.equals(n3)) {
			palinArr.add(n3);
		}else {
			strArr.add(n3);
		}
		if(reverse4.equals(n4)) {
			palinArr.add(n4);
		}else {
			strArr.add(n4);
		}
		if(reverse5.equals(n5)) {
			palinArr.add(n5);
		}else {
			strArr.add(n5);
		}
		if(reverse6.equals(n6)) {
			palinArr.add(n6);
		}else {
			strArr.add(n6);
		}
		if(reverse7.equals(n7)) {
			palinArr.add(n7);
		}else {
			strArr.add(n7);
		}
		if(reverse8.equals(n8)) {
			palinArr.add(n8);
		}else {
			strArr.add(n8);
		}
		if(reverse9.equals(n9)) {
			palinArr.add(n9);
		}else {
			strArr.add(n9);
		}
		if(reverse10.equals(n10)) {
			palinArr.add(n10);
		}else {
			strArr.add(n10);
		}
		if(reverse11.equals(n11)) {
			palinArr.add(n11);
		}else {
			strArr.add(n11);
		}
		if(reverse12.equals(n12)) {
			palinArr.add(n12);
		}else {
			strArr.add(n12);
		}
		
		System.out.println("The string arraylist");
		for(String c : strArr) {
			System.out.println(c);
		}
		System.out.println("The string arraylist that has palindromes");
		for(String b : palinArr) {
			System.out.println(b);
		}
	}
	//this is the method that handles the string reversal
	protected static String reverseString(String value) {
		String temp = "";
		for(int i = value.length()-1; i>=0; i--) {
			temp += value.charAt(i);
		}
		return temp;
	}
	
}
