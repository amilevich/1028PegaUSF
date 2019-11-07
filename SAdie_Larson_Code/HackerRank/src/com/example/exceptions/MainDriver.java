package com.example.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainDriver {

	public static void main(String[] args) {
		boolean validInput = false;
		int digit;
		Scanner sc = new Scanner(System.in);

		while (!validInput) {
			try {
				digit = sc.nextInt();
			} catch (InputMismatchException e) {
				//e.printStackTrace();
				System.err.println("Entered value is not an integer");
			}
			sc.nextLine();
		}
	}

}
 