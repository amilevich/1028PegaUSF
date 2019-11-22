package com.examples.corehomework;

import java.util.ArrayList;
import java.util.List;

public class Q09PrimeNumbers {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		System.out.println("List of prime numbers from 1 to 100 \n");

		int i;

		for (i = 1; i <= 100; i++)
			list.add(i);

		for (int num : list) {
			for (i = 2; i < num; i++) {
				if (num % i == 0)
					break;
			}
			if (i == num)
				System.out.println(num + " ");
			
		}
	}
}