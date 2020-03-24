package com.example.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainDriver {

	public static void main(String[] args) {
		boolean validInput = false;
		int digit = 0;
		boolean exceptionCaught = true;
		Scanner sc = new Scanner(System.in);

		while (!validInput && exceptionCaught) {
			exceptionCaught = false;
			try {
				digit = sc.nextInt();
			} catch (Exception e) {
				//e.printStackTrace();
				System.out.println("Entered value is not an integer");
				exceptionCaught = true;
			}
			if(digit == 1) {
				System.out.println("Yay it is 1");
			}
			sc.nextLine();
			
		}
		System.out.println("Outside of while");
	}

}
 