package davidvallejo.hw.javacore;

import java.util.Scanner;

/*
 * 
 * Question 17: Write a program that calculates the simple interest on the principal, rate of
 * interest and number of years provided by the user. Enter principal, rate and time
 * through the console using the Scanner class.
 * 
 * Interest = Principal* Rate* Time
 * 
 */
public class Question17 {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		while(true) {
			double interest = interest();//interest equal to interest method
			System.out.println("The interest accrued will be : " + interest);
			System.out.println("---------------------------");
		}
	}

	public static double interest() {
		System.out.println("What is the principal value: ");
		double a = sc.nextDouble();
		System.out.println("what is your interest rate: ");
		double b = sc.nextDouble();
		System.out.println("what is the time in years you will be paying this back: ");
		double c = sc.nextDouble();
		
		return a*b*c; //calculating the interest based on the user input
		
	}
}
