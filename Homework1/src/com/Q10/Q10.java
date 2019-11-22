package com.Q10;

public class Q10 {
	
	static void ternary(int a, int b) {
		int minValue = a<b ? a:b;
		System.out.println(minValue);
	}
	public static void main(String[] args) {
		//Q10. Find the minimum of two numbers using ternary operators.
		ternary(5, 8);
		
	}
}

