package com.example.scanner;

import java.util.Scanner;

public class MyClass {

	/*
	 * The Scanner Class
	 * used to get user input through the console
	 * found in java.util package 
	 */
	public static void main(String[] args) {
		//create a scanner object
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter your name:");
		String name = sc.nextLine();
		System.out.println("Hello " + name + "!");
		
		System.out.println(name + " How old are you?:");
		int age = sc.nextInt();
		System.out.println("Wow I cannot belive you are only " + age + " years old!");
		if(age>=21) {
			System.out.println("You are legal! Please enter the store.");
		}
		else {
			System.out.println("Sorry you are too young, see you when you are older.");
		}
		
		
		System.out.println("What is your phone number?");
		long phoneNum = sc.nextLong();
		
	}
}
