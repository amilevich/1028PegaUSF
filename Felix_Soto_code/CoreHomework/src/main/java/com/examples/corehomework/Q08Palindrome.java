package com.examples.corehomework;

import java.util.ArrayList;

public class Q08Palindrome {

	public static void main(String[] args) {

		ArrayList<String> arr = new ArrayList<String>();//stores not polindromes
		ArrayList<String> arr1 = new ArrayList<String>();//stores polindromes


		String s1 = "karan";
		String s2 = "madam";
		String s3 = "tom";
		String s4 = "civic";
		String s5 = "radar";
		String s6 = "sexes";
		String s7 = "jimmy";
		String s8 = "kayak";
		String s9 = "john";
		String s10 = "refer";
		String s11 = "billy";
		String s12 = "did";
		
		String reverse1 = reverseString(s1);
		String reverse2 = reverseString(s2);
		String reverse3 = reverseString(s3);
		String reverse4 = reverseString(s4);
		String reverse5 = reverseString(s5);
		String reverse6 = reverseString(s6);
		String reverse7 = reverseString(s7);
		String reverse8 = reverseString(s8);
		String reverse9 = reverseString(s9);
		String reverse10 = reverseString(s10);
		String reverse11 = reverseString(s11);

		if(reverse1.equals(s1)) {
			arr1.add(s1);
		}else {
			arr.add(s1);
		}
		
		if(reverse2.equals(s2)) {
			arr1.add(s2);
		}else {
			arr.add(s2);
		}
		
		if(reverse3.equals(s3)) {
			arr1.add(s3);
		}else {
			arr.add(s3);
		}
		
		if(reverse4.equals(s4)) {
			arr1.add(s4);
		}else {
			arr.add(s4);
		}
		
		if(reverse5.equals(s5)) {
			arr1.add(s5);
		}else {
			arr.add(s5);
		}
		
		if(reverse6.equals(s6)) {
			arr1.add(s6);
		}else {
			arr.add(s6);
		}
		
		if(reverse7.equals(s7)) {
			arr1.add(s7);
		}else {
			arr.add(s7);
		}
		
		if(reverse8.equals(s8)) {
			arr1.add(s8);
		}else {
			arr.add(s8);
		}
		
		if(reverse9.equals(s9)) {
			arr1.add(s9);
		}else {
			arr.add(s9);
		}
		
		if(reverse10.equals(s10)) {
			arr1.add(s10);
		}else {
			arr.add(s10);
		}
		
		if(reverse11.equals(s11)) {
			arr1.add(s11);
		}else {
			arr.add(s11);
		}
	
		
        System.out.println("Not palindrome!");
		for(String st : arr) {
			System.out.println(st);
		}
		System.out.println();
		 System.out.println("Palindrome!");
		 
		for(String st1 : arr1) {
			System.out.println(st1);
		}
		
		}
	
		
	private static String reverseString(String word) {
        String temp ="";
		for(int i =  word.length()- 1; i >= 0; i--) {
			temp += word.charAt(i);
		}
		return temp;
	}

}
