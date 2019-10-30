package com.example.scanner;

import java.util.Scanner;

public class MyClass {

	/* 
	 * Scanner class takes input from the user.
	 * java.util
	 */
	
	public static void main(String[] args) {
		
		//create scanner object
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your name");
		
		String name = sc.nextLine();
		System.out.println("Hello, " + name );
		
		System.out.println(name + " how old are you?");
		System.out.println("You are " + sc.nextLine() + " years old.");
		
		System.out.println("What is your phone number?");
		long phoneNumber = sc.nextLong();
		
	}
}
