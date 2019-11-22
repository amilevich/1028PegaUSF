package problemz17;

import java.util.Scanner;

public class Solution17 {
	
	public static void main(String[] args) {
		double interest = calculate_interet();
		System.out.println(interest);
	}

	public static double calculate_interet() {
		Scanner sc = new Scanner(System.in);
		System.out.println("What is the principal");
		double principal = sc.nextDouble();
		System.out.println("What si the rate?");
		double rate = sc.nextDouble();
		System.out.println("What is the time?");
		double time = sc.nextDouble();
		double interest = principal * rate * time; 
		return interest;
	}

}
