package com.example.pigeonhole;

import java.util.Arrays;

public class MyClass {
	// time complexity of O(n+range)
	public static void main(String[] args) {
		int arr[] = { 5, 3, 2, 7, 4, 6, 8 };
		pigeonHole(arr);
		printArray(arr);
	}

	public static void pigeonHole(int arr[]) {
		int min = arr[0];
		int max = arr[0];
		int range, i, j, index;

		for (i = 0; i < arr.length; i++) {
			if (arr[i] > max)
				max = arr[i];
			if (arr[i] < min)
				min = arr[i];
		}

		range = max - min + 1;
		int[] phole = new int[range];
		Arrays.fill(phole, 0);

		for (i = 0; i < arr.length; i++) {
			phole[arr[i] - min]++;
		}

		index = 0;

		for (j = 0; j < range; j++) {
			while (phole[j]-- > 0) {
				arr[index++] = j + min;
			}
		}
	}

	public static void printArray(int arr[]) {
		for (int i : arr) {
			System.out.print(i + ", ");
		}
	}

}
