package Q17InterestOnPrinciple;

import java.util.Scanner;

public class InterestOnPrinciple {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the starting principle:");
		int p =  sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the interest rate:");
		double i =  sc.nextDouble();
		sc.nextLine();
		System.out.println("Enter the term length in years:");
		int y =  sc.nextInt();
		sc.nextLine();
		
		System.out.println("The simple interest on $"+p+", at a rate of "+i+"%, for a term of "+y+" years is: $"+p*i*y/100);
		
	}

}
