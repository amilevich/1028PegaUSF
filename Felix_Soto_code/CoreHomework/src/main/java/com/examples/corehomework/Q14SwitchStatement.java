package com.examples.corehomework;

import java.util.Date;
import java.util.Scanner;

public class Q14SwitchStatement {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int options;
		System.out.println("1.Let's first find the square root of a given number");
		System.out.println("2.Let's display today's date");
		System.out.println("3.Lets split a string into two");
		options = sc.nextInt();
		 
		 switch(options) {
		 case 1:
			 System.out.println("Enter a number to find the square root: ");
			 double n = (double)Math.sqrt(sc.nextInt());
			 System.out.println(n);
			 break;
			 
		 case 2:
			 System.out.println("Today's date is:");
			 Date date = new Date();
			 System.out.println(date);
			 
			 break;
			 
			 
		 case 3:
			 System.out.println("Enter a string");
			 
			 String  s = "I am learning Core Java";
			 String[] arr = s.split(" ");
			 for(int i = 0; i < arr.length; i++) {
				 System.out.println(arr[i]);
			 }
			 
			 break;
			 
			 
		 }
		
	}

}
