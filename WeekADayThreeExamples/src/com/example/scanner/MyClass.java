package com.example.scanner;

import java.util.Scanner;

public class MyClass {
	/*
	 * The scanner class is used to get user input through the console.
	 * It is found in the java.util package
	 * */
	
	public static void main(String[] args) {
		
		//create a Scanner object
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your name: ");
		
		String name = sc.nextLine(); //declaring a variable of type string to store the input
		
		System.out.println("Hello, " + name);
		
		System.out.println("Gimme dem digits");
		long phoneNumber = sc.nextLong();
		
		System.out.println(name + " How old are you?");
		int age = sc.nextInt();
		
		if(age>20) {
			System.out.println("You are legal, please enter the Liquor store");
		}else {
			System.out.println("Please come back when you are 20");
		}
		
		
	}
}
