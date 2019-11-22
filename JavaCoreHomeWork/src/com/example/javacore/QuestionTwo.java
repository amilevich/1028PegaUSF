package com.example.javacore;
/*
 * Write a program to display the first 25 Fibonacci numbers beginning at 0.
 */

public class QuestionTwo {

	public static void main(String[] args) {
		int i;
		int a = 0;
		int b = 1;
		int c = 0;
		int fibonacci = 25;
		fibonacci = fibonacci - 2;
		System.out.println(a);
		System.out.println(b);
		for (i = 1; i <= fibonacci; i++) {
			c = a + b;
			a = b;
			b = c;
			System.out.println(c); 
		}

	}

}
