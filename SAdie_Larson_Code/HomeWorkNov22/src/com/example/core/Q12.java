package com.example.core;
//DONE
/*
 * Write a program to store numbers from 1 to 100 in an array.
 * Print out all the even numbers from the array. 
 * Use the enhanced FOR loop for printing out the numbers
 */
import java.util.ArrayList;

public class Q12 {

	public static void main(String[] args) {

		ArrayList<Integer> numA = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			numA.add(i + 1);
		}
		Object[] num = numA.toArray();
		printEven(num);

	}

	public static void printEven(Object[] num) {
		for (Object i : num) {
			int temp = (int) i;
			if ((temp % 2) == 0) {
				System.out.println(i);
			}

		}
	}
}
