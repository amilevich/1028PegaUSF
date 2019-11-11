package com.example.core;
//DONE
/*
 * Write a program to determine if an integer
 *  is even without using the modulus operator (%)
 */
//check if 0 is neutral meaning not even
public class Q6 {

	public static void main(String[] args) {

		int n = 7;
		System.out.println("Is the number " + n + " even: " + evenCheck(n));
		n = 2;
		System.out.println("Is the number " + n + " even: " + evenCheck(n));
		n = 10000003;
		System.out.println("Is the number " + n + " even: " + evenCheck(n));
		n = 928;
		System.out.println("Is the number " + n + " even: " + evenCheck(n));
		n = 0;
		System.out.println("Is the number " + n + " even: " + evenCheck(n));
	}

	public static boolean evenCheck(double n) {
		double temp = n / 2;
		int whole = (int) n / 2;
		if (n == 0) {
			return false;
		}
		if ((temp - whole) == 0.5) {
			return false;
		}
		return true;
	}

}
