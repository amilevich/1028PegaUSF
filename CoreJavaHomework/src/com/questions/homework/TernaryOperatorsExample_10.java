package com.questions.homework;

public class TernaryOperatorsExample_10 {
	
	public static void main(String[] args) {
		int a = 100;
		int b = 1000;
		int max = a >= b ? a : b;// Conditional if statement, old school java. Asking if a is greater than or equal to b, 
								//if false go to the correct greater value and print that
		
		System.out.println(max);
	}

}
