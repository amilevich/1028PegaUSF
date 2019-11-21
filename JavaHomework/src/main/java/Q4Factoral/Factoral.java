package Q4Factoral;

import java.util.Scanner;

public class Factoral {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please provide an integer value to compute the factorial of:");
		int n = sc.nextInt();

		System.out.println("\nThe factorial of "+n+" is: " + factorial(n));

	}
	
	public static int factorial(int n) {
		if(n ==1)
			return 1;
		else
			return (n*factorial(n-1));
	}

}
