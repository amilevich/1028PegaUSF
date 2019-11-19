package com.example.homework;

public class Q6 {

	public void evenOrOdd(int n) {
		// Format this answer
		System.out.println("");
		// If number is less than 0 take the absolute value of it then divide by 2
		// and multiply by two to see if it equals itself
		if (n < 0) {
			Math.abs(n);
			if ((n / 2) * 2 == n) {
				System.out.println("Number is even.");
			} else {
				System.out.println("Number is odd.");
			}

		// If number is greater than 0 take the absolute value of it then divide by 2
		// and multiply by two to see if it equals itself
		} else if (n > 0) {
			if ((n / 2) * 2 == n) {
				System.out.println("Number is even.");
			} else {
				System.out.println("Number is odd.");
			}
		//If number is zero	
		} else {
			System.out.println("Zero is neither an even number");
		}

	}

}
