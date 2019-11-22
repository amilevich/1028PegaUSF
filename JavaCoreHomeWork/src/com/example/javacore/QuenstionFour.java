package com.example.javacore;
/*
 * Write a program to compute N factorial.
 */
import java.util.Scanner;

public class QuenstionFour {

	public static void main(String[] args) {
		
        Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter a number");
		int number = scan.nextInt(); 
		int a = number;
		int f = 1;		
		while (number != 0) {
			f = f * number; 
			number = number - 1;// subtracting each number selected by one
		}
		System.out.println("The factorial of " + a + " is: " + f);

	}

}
