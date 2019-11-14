package com.assignment1;

import java.util.Date;
import java.util.Scanner;

public class Q14 {
	public static void main(String[] args) {
		
		System.out.println("enter input");
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		
		switch(input){
			case 0:
				System.out.println("Input a number you'd like to find the square root of");
				input = in.nextInt();
				System.out.println(Math.sqrt(input));
				break;
			case 1:
				Date todaysDate = new Date();
				System.out.println(todaysDate.toString());
				break;
			case 2:
				String string = "I am Learning Core Java";
				String[] stringArray = string.split(" ");
				for(String i:stringArray) {
					System.out.println(i);
				}
				break;
				
				
		}
	}

}
