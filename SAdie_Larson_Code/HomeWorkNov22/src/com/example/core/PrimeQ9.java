package com.example.core;
//DONE
/*
 * Create an ArrayList which stores numbers from 1 to 100 and prints out all the
 * prime numbers to the console
 */

import java.util.ArrayList;
import java.util.Iterator;

public class PrimeQ9 {

	public static void main(String[] args) {

		ArrayList<Integer> prime = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			prime.add(i + 1);
		}
		primePrinter(prime);

	}

	public static void primePrinter(ArrayList<Integer> n) {

		Iterator<Integer> p = n.iterator();
		while (p.hasNext()) {
			int temp = p.next();
			if ((temp == 2) || (temp == 3) || (temp == 5) || (temp == 7) && (temp != 1)) {
				System.out.println(temp);
			} else if (((temp % 2) != 0) && ((temp % 3) != 0) && ((temp % 5) != 0) && ((temp % 7) != 0)
					&& (temp != 1)) {
				System.out.println(temp);
			}
		}

	}

}
