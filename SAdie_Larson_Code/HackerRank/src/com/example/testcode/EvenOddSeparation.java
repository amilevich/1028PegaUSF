package com.example.testcode;

import java.util.ArrayList;

public class EvenOddSeparation {

	public static void main(String[] args) {
		int[] number = { 10, 4, 5, 6, 7, 8, 2, 3, 2, 9 };
		evenOdd(number);

	}

	public static void evenOdd(int[] num) {
		ArrayList<Integer> even = new ArrayList<Integer>();
		ArrayList<Integer> odd = new ArrayList<Integer>();
		int even1 = 0;
		int odd1 = 0;
		for (int i = 0; i < num.length; i++) {
			if ((num[i] % 2 == 0)) { // even
				even.add(num[i]);
				even1++;
			} else {
				odd.add(num[i]);
				odd1++;
			}
		}
		System.out.println("There are " + even1 + " evens:");
		System.out.println(even);
		System.out.println("There are " + odd1 + " odds:");
		System.out.println(odd);
	}
	// more efficient method would be adding array to a set and sorting
	// then using just one for loop --> better efficiency
}
