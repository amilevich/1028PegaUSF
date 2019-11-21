package com.javahomework.questions;

import java.util.ArrayList;
/*
 * Create an ArrayList and insert integers 1 through 10. Display the ArrayList. 
 * Add all the even numbers up and display the result. Add all the odd numbers up and display the result.
 *  Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
 * */
public class QuestionNineteenClass {
	public static void main(String[] args) {
		Integer even = 0, odd=0; //declaring my variables
		ArrayList<Integer>intArr = new ArrayList<Integer>();//declaring a list
		for(int i = 1; i <= 10; i++) { //iterating the list to ten and adding the ten elements
			intArr.add(i);
		}
		//displaying the arraylist
		System.out.println("Normal Array List: ");
		for(Integer i : intArr) {
			System.out.print(i + " ");
		}
		for(int a = 0; a < intArr.size(); a++) { //looping the list again and checking to see if even
			if(intArr.get(a)%2==0) {
				even += intArr.get(a);
				intArr.remove(a);
			}else {
				odd += intArr.get(a);
			}
			
		}
		System.out.println("\n");
		System.out.println("Sum result of all even numbers added: " + even);
		System.out.println("Sum result of all odd numbers added: " + odd);
		System.out.println("ArrayList after removing prime numbers: ");
		for(Integer aa : intArr) {
			System.out.print(aa + " ");
		}
	}
}
