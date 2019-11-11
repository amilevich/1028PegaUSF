package com.example.core;
//DONE

/*
 * Write a program to display the first 25 Fibonacci numbers beginning at 0. 
 */
public class FibonacciQ2 {
	/*
	 * Recursion
	 */
	public static int x = 0, y = 1, z = x + y;

	public static void main(String[] args) {
		System.out.print(x + ", " + y + ", ");
		fibonacci(25);
	}

	public static int fibonacci(int repeat) {
		if (repeat > 0) {
			z = x + y;
			System.out.print(z + ", ");
			x = y;
			y = z;
			return fibonacci(repeat - 1);
		} else {
			return 0;
		}
	}

}
