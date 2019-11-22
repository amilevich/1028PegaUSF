package com.examples.corehomework;

import java.util.Scanner;

public class Q03Reverse {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the word  or sentence you want to get reversed");
		String input = sc.nextLine();


		byte[] byteConv = input.getBytes();

		byte[] result = new byte[byteConv.length];

		// Store result in reverse order into the
		// result byte[]
		for (int i = 0; i < byteConv.length; i++)
			result[i] = byteConv[byteConv.length - i - 1];
		System.out.println("This is the reversed word or sentence");
		System.out.println(new String(result));
	}
}
