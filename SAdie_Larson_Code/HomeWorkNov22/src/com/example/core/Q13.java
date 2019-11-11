package com.example.core;

//DONE
/*
 * Display the triangle on the console as follows using any type of loop.  Do NOT use a simple group of print statements to accomplish this.
    0
    1 0
    1 0 1
    0 1 0 1

 */
import java.util.ArrayList;

public class TriangleQ13 {

	public static void main(String[] args) {
		int x = 4;
		triangle(x);
	}

	public static void triangle(int n) {
		boolean zero = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (zero) {
					System.out.print(0 + " ");
					zero = false;
				} else {
					System.out.print(1 + " ");
					zero = true;
				}
			}
			System.out.println();
		}
	}
}
