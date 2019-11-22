package com.homework.qsix;

import java.util.Scanner;

public class Qsix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Put a number in: ");
		//Number to be tested
		int numberToTest = sc.nextInt();
		
		//divided numberToTest by 2
		int evenTest = numberToTest/2;
		
		//is even number
		if(evenTest*2== numberToTest) {
			System.out.println(numberToTest + " is an even number.");
		//is odd number
		}else {
			System.out.println(numberToTest + " is an odd number.");
		}

	}

}
