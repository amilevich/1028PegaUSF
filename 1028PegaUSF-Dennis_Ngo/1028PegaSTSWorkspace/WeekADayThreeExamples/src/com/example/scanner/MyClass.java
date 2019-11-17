package com.example.scanner;

import java.util.Scanner;

public class MyClass {
	/*
	 *Scanner Class used to get user input through console
	 *Found in java.util package
	 */
	
	public static void main(String[] args) {
		
		//create Scanner obj
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your name: ");
		
		String name = sc.nextLine();
		System.out.println("Hello, " + name);
		
		System.out.println("What is your phone number:");
		long phoneNumber = sc.nextLong();
		
		System.out.println(name = ", how old are you?");
		int age = sc.nextInt();
		if(age>20){
			System.out.println("You are legal, enter the liquor store.");
		}else {
			System.out.println("Come back when you're 21.");
		}
		
		
		
		
		
		
	}
}
