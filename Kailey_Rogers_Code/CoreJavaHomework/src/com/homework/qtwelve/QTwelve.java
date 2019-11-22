package com.homework.qtwelve;

public class QTwelve {

	public static void main(String[] args) {

		int twelveArray[] = new int[101];
		for (int i = 1; i < 101; i++) {
			twelveArray[i] = i;
		}
		
		for (int x : twelveArray) {
			if (x % 2 == 0  && x > 0) {
				System.out.print(x + " ");
			}
		}
	}
}
