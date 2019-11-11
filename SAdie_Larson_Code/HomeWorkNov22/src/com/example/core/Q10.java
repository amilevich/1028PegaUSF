package com.example.core;
//DONE
/*
 * Find the minimum of two numbers using ternary operators
 */
public class Q10 {

	public static void main(String[] args) {
		int a = 10, b = 20;
		ternary(a, b);
		
		a = 100;
		b = 20;
		ternary(a, b);
		
	}

	public static void ternary(int x, int y) {
		int temp = (x < y) ? x : y;
		System.out.println(temp);
	}
}
