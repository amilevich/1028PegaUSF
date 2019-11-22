package com.homework.HW1;

//Q6 - Method to find out if number is odd/even without using modulo.

public class Q6_EvenOdd {

	public static void main(String[] args) {

		OddEven(9);
		OddEven(4);
		OddEven(21);

	}

	public static void OddEven(int x) {

		int check1 = x; 
		double check2 = x;

		check1 = x / 2;
		check2 = x / 2.00; 

		if (check1 == check2) { //Values will not be equal if the number is odd, as the int wouldnt display the correct number.
			System.out.println(x + " is an even number");
		} else {
			System.out.println(x + " is an odd number");
		}

	}
}
