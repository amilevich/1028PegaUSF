package interview.questions;

import java.util.Scanner;

public class QSeventeen {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Principal: ");
		double principal = sc.nextDouble();
		System.out.println("Rate: ");
		double rate = sc.nextDouble();
		System.out.println("Time: ");
		double time = sc.nextDouble();

		double simpleInterest = principal * rate * time;
		System.out.println("Interest: " + simpleInterest);

	}
}
