package com.homework.qnine;

import java.util.ArrayList;
import java.util.List;

public class Qnine {

	public static void main(String[] args) {
		int x = 100;
		List<Integer> hundredArray = new ArrayList<Integer>();

		for (int i = 1; i <= x; i++) {

			hundredArray.add(i);
		}
		System.out.println(hundredArray);

		for (int i = 0; i < hundredArray.size() - 1; i++) {
			if (!isPrime(hundredArray.get(i))) {
				hundredArray.remove(hundredArray.get(i));
				i--;
			}
		}
		System.out.println(hundredArray);
	}

	public static boolean isPrime(int x) {
		boolean itIs = true;
		for (int i = 2; i < x; i++) {
			if (x % i == 0) {
				itIs = false;
			}
		}
		return itIs;

	}

}
