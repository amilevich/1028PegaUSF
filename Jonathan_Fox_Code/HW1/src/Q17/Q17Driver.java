package Q17;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Q17Driver {

	// Write a program that calculates the simple interest on the principal, rate of
	// interest and number of years provided by the user. Enter principal, rate and
	// time through the console using the Scanner class.
	// Interest = Principal* Rate* Time

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double p, r;
		int t;
		
		
		System.out.printf("Input principal\n");
		try {
			p = Double.valueOf(input.nextLine());
			System.out.printf("Input rate\n");
			r = Double.valueOf(input.nextLine());
			System.out.printf("Input number of years\n");
			t = Integer.valueOf(input.nextLine());
			System.out.printf("Interest = %f\n", p*r*t);
		}
		catch(NoSuchElementException e) { error(); }
		
		input.close();
	}

	public static void error() { System.out.printf("Improper input\n"); System.exit(1); }
}
