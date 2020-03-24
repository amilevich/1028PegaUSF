package com.example.testcode;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PrintArray {

	static void plusMinus(int[] arr) {
		double pos = 0.000000;
		double neg = 0.000000;
		double zer = 0.000000;
	
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 1) {
				pos++;
			} else if (arr[i] < 0) {
				neg++;
			} else {
				zer++;
			}
		}
		double positive = pos / arr.length;
		double negative = neg / arr.length;
		double zero = zer / arr.length;
		System.out.println(positive);
		System.out.println(negative);
		System.out.println(zero);

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		int[] arr = new int[n];
		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}
		plusMinus(arr);
		scanner.close();

	}
}
