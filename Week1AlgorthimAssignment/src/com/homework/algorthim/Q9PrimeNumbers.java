package com.homework.algorthim;

import java.util.ArrayList;

public class Q9PrimeNumbers {
	ArrayList<Integer> primeN = new ArrayList<Integer>();

	// static int count = 0;
	//
	public void primeNum() {

		for (int i = 0; i <= 100; i++) {
			System.out.println(i);

			if (i == 2 || i == 3 || i == 5 || i == 7) {
				primeN.add(i);
			} else if(i % 2 != 0 && i % 3 != 0 && i % 5 != 0 && i % 7 != 0) {
				primeN.add(i);
			}

		}
		
		System.out.println("these are prime numbers. " + primeN);
	}
}
