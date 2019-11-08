package com.example.testcode;

public class LastDigitMatch {

	public static void main(String[] args) {
		if (lastDigit(124, 24)) {
			System.out.println("equal last digits");
		} else {
			System.out.println("boo");
		}
	}

	public static boolean lastDigit(int a, int b) {

		String x = String.valueOf(a);
		String y = String.valueOf(b);

		if ((x.charAt(x.length() - 1)) == (y.charAt(y.length() - 1))) {
			return true;
		} else {
			return false;
		}
	}
}
