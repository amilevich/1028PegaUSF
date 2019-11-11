package com.example.core;

/*
 * Write a program that defines an interface having the following methods:
 * addition, subtraction, multiplication, and division. 
 * Create a class that implements this interface and provides appropriate 
 * functionality to carry out the required operations. Hard code two operands 
 * in a test class having a main method that calls the implementing class.
 */
//TO DO: make sure it is an int entered
import java.util.Scanner;

public class Q15 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Q15MathC test = new Q15MathC();
		String x, y;
		String op;
		double tempNum = 0;
		while (true) {
			System.out.println("Please enter first value: ");
			while (true) {
				x = sc.nextLine();
				try {
					tempNum = Double.valueOf(x);
				} catch (Exception e) {
					System.out.println("Entered value must be a number");
					continue;
				}
				break;
			}
			while (true) {
				System.out.println("Please enter operand: +, -, *, / ");
				op = sc.nextLine();
				if ((op.equals("+")) || (op.equals("-")) || (op.equals("*")) || (op.equals("/"))) {
					break;
				}
			}
			System.out.println("Please enter second value: ");
			y = sc.nextLine();
			while (true) {
				try {
					tempNum = Double.valueOf(y);
				} catch (Exception e) {
					System.out.println("Entered value must be a number");
					continue;
				}
				break;
			}
			switch (op) {
			case "+":
				System.out
						.println("Answer: " + x + op + y + "=" + test.addition(Double.valueOf(x), Double.valueOf(y)));
				break;
			case "-":
				System.out.println(
						"Answer: " + x + op + y + "=" + test.subtraction(Double.valueOf(x), Double.valueOf(y)));
				break;
			case "*":
				System.out.println(
						"Answer: " + x + op + y + "=" + test.multiplication(Double.valueOf(x), Double.valueOf(y)));
				break;
			case "/":
				System.out
						.println("Answer: " + x + op + y + "=" + test.division(Double.valueOf(x), Double.valueOf(y)));
				break;
			}
			System.out.println("-----------------------------------");
		}
	}
}
