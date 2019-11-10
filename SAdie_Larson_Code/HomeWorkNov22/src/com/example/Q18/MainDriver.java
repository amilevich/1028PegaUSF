package com.example.Q18;
//
/*
 * Write a program having a concrete subclass that inherits three 
 * abstract methods from a superclass.  Provide the following three 
 * implementations in the subclass corresponding to the abstract methods 
 * in the superclass: 

1. Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
2. Convert all of the lower case characters to uppercase in the input string, and return the result. 
3. Convert the input string to integer and add 10, output the result to the console.

* Create an appropriate class having a main method to test the above setup.

 */
//TO DO: double check
import java.util.Scanner;

public class MainDriver {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		SuperC test = new SubC();

		String temp;
		// uppercase count
		System.out.println("Please enter a string:");
		temp = sc.nextLine();
		System.out.println("It has uppercase letter: " + test.upperCase(temp));

		// lower to upper

		System.out.println("Please enter a string:");
		temp = sc.nextLine();
		System.out.println("The string '" + temp + "' in all uppercase letters: " + test.convertToUpper(temp));

		// convert to int and add 10
		System.out.println("Please enter a number to add to 10: ");
		temp = sc.nextLine();
		System.out.println("The value is " + test.convertToInt(temp));
	}

}
