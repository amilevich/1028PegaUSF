package com.homework.qten;

import java.util.Scanner;

public class Qten {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int temp1;
		int temp2;
		int ternary;
		System.out.print("Please enter a number: ");
		temp1 = sc.nextInt();
		System.out.print("Please enter another number: ");
		temp2 = sc.nextInt();
		
		ternary = (temp1 < temp2) ? temp1 : temp2;
		System.out.println("The minimum number between " + temp1 + " and " +
		temp2 + " is " + ternary + ".");
		

	}

}
