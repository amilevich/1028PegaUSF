package com.example.testcode;

public class FizzBuzz {

	public static void main(String[] args) {
		for (int i = 0; i <= 100; i++) {
			System.out.print(i + ": ");
			if ((i % 5) == 0 && (i % 3) == 0) {
				System.out.print("FizzBuzz");
			} else if ((i % 5) == 0) {
				System.out.print("Fizz");
			} else if ((i % 3) == 0) {
				System.out.print("Buzz");
			}
			System.out.println();
		}
	}
}
