package com.homework.Q14;

import java.lang.Math;
import java.util.Date;
import java.util.Scanner;

public class SwitchClass {

	public static void main(String[] args) {
		
		System.out.println("Please enter a number for a case");
		System.out.println("1)Square root");
		System.out.println("2)Today's date");
		System.out.println("3)String split");
		
		Scanner dre = new Scanner(System.in);
		int value = dre.nextInt();
		// Switch statement to  choose 3 options
		switch(value) {
		case 1:
			System.out.println("Please enter a number:");
			int num = dre.nextInt();
			sqrtroot(num);
			break;
		case 2:
			// Date is used to determine the current dat and time, defined in data util.
			Date rn = new Date();
			System.out.println("Today's date: " + rn);
			break;
		case 3:
			String s = new String("I am learning Core java");
			
			// spliting the string by identifying spaces
			String[] y = s.split(" ");
			
			// printing out array
			for(int i =0; i <y.length; i++) {

				System.out.println(y[i]);
			}
			break;
		
		}

	}
	public static int sqrtroot(int num1) {
		System.out.println(Math.sqrt(num1));
				
				
		return 0;
	}
}
