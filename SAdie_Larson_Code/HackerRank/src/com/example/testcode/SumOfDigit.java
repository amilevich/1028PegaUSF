package com.example.testcode;

public class SumOfDigit {
	public static void main(String[] args) {

		System.out.println(sumOfDigit(43));
	}

	public static int sumOfDigit(int a) {
		String x = String.valueOf(a);
		a = 0;
		for (int i = 0; i < x.length(); i++) {
			a = a + Character.getNumericValue((x.charAt(i)));
			}
		return a;
	}
}
