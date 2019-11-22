package com.questions.homework;

import java.util.Scanner;

public class EvenNumbersExample_6 {

	public static void main(String[] args) {
		findEven();
	}
	
	public static void findEven() {
		System.out.println("Enter a number");
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		sc.nextLine();
		
		int num = x / 2;
		
		while(num != 0) {
			num = x / 2;
			if(num == 1) {//if number is divisible by 2 reaches 0, meets condition to be even
				System.out.println("This is an even number.");
				break;
			}else{// by default this number has to odd
				System.out.println("This is a odd number.");
				break;
			}

		}

		
	}
}
