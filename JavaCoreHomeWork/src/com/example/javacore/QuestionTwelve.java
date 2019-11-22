package com.example.javacore;
/*
 *  Write a program to store numbers from 1 to 100 in an array. 
 *  Print out all the even numbers from the array. Use the 
 *  enhanced FOR loop for printing out the numbers.
 */
public class QuestionTwelve {

	public static void main(String[] args) {

		int [] evens = new int[102];// I set my array until 102 so it can print until 100
		for(int i = 1; i < evens.length; i++) {
			evens[i] = i;
		}
		// iterating through the (even) array and printing only even numbers
		for(int a : evens) {
			if(evens[a] % 2 == 0) {
				System.out.println(a);
			}
		}
	
		
	}

}
