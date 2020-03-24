package com.example.testcode;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MiniMaxSum {
	// Complete the miniMaxSum function below.
	static void miniMaxSum(int[] arr) {
		int sum[] = { 0, 0, 0, 0, 0 };
		sum[0] = arr[0] + arr[1] + arr[2] + arr[3];
		int base = sum[0];

		int min = base;
		int max = base;

		sum[1] = arr[0] + arr[1] + arr[2] + arr[4]; // without the fourth element
		sum[2] = arr[0] + arr[1] + arr[3] + arr[4]; // without the third element
		sum[3] = arr[0] + arr[2] + arr[3] + arr[4];// without the second element
		sum[4] = arr[1] + arr[2] + arr[3] + arr[4];// without the first element

		for (int i = 1; i < 5; i++) {
			if (sum[i] > max) {
				max = sum[i];
			}
			if (sum[i] < min) {
				min = sum[i];
			}
		}
		System.out.println(min + " " + max);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = new int[5];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < 5; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		miniMaxSum(arr);

		scanner.close();
	}
}
