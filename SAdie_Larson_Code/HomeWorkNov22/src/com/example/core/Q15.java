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


public class InterfaceClassQ15 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MathC test = new MathC();
		String x, y;
		String op;
		while (true) {
				System.out.println("Please enter first value: ");
				x = sc.nextLine();
			while (true) {
				System.out.println("Please enter operand: +, -, *, / ");
				op = sc.nextLine();
				if ((op.equals("+")) || (op.equals("-")) || (op.equals("*")) || (op.equals("/"))) {
					break;
				}
			}
			System.out.println("Please enter second value: ");
			y = sc.nextLine();
			switch (op) {
			case "+":
				System.out
						.println("Answer: " + x + op + y + "=" + test.addition(Integer.valueOf(x), Integer.valueOf(y)));
				break;
			case "-":
				System.out.println(
						"Answer: " + x + op + y + "=" + test.subtraction(Integer.valueOf(x), Integer.valueOf(y)));
				break;
			case "*":
				System.out.println(
						"Answer: " + x + op + y + "=" + test.multiplication(Integer.valueOf(x), Integer.valueOf(y)));
				break;
			case "/":
				System.out
						.println("Answer: " + x + op + y + "=" + test.division(Integer.valueOf(x), Integer.valueOf(y)));
				break;
			}
			System.out.println("-----------------------------------");
		}
	}

}
