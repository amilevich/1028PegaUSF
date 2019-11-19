package com.homework.HW1;

//Q2 - Display Fibonacci Numbers up to 25

public class Q2_Fib {
	public static void main(String[] args) {

		fibSequence(25);
		
	}

	public static void fibSequence(int x) {
		int t1 = 0; //first term to be added
		int t2 = 1; //second term

		for (int i = 1; i <= x; i++) {
			System.out.print(t1 + ",");//Print the current term.
			int sum = t1 + t2; //This will become the second term
			t1 = t2; //Second term is now first term
			t2 = sum; //Values swapped
		}
	}
}
