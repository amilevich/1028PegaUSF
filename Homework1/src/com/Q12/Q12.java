package com.Q12;

import java.util.ArrayList;

public class Q12 {
	
	  //Q12. Write a program to store numbers from 1 to 100 in an array. Print out all the even numbers from the array. Use the enhanced FOR loop for printing out the numbers.
	 static ArrayList<Integer> checkEven() {
		 int i = 0;
		 ArrayList<Integer> arraylist = new ArrayList<Integer>();
		 ArrayList<Integer> arraylisteven = new ArrayList<Integer>();
		 while (arraylist.size() <= 100) {
			 arraylist.add(i);
			 i++;
		 }
		 for(Integer y: arraylist) {
			 if(y%2==0) 
		        	arraylisteven.add(y);
		 }
		 return arraylisteven;
	 }
	public static void main(String[] args) {
		System.out.println("Even Numbers list " + checkEven());
	}
}
