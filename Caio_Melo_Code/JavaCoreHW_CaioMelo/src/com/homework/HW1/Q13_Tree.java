package com.homework.HW1;


/*
 * Q13 -  Display triangle using any kind of loop.
 */


public class Q13_Tree {
	public static void main(String[] args) {

		for (int i = 1; i <= 4; i++) {

			if (i == 2 | i == 3) {
				for (int k = 0; k < i; k++) {
					System.out.print((k + 1) % 2);
				}
			}
			else {
			for (int j = 0; j < i; j++) {

				System.out.print((j) % 2);
			}
			}
			System.out.println();

		}
	}

}
