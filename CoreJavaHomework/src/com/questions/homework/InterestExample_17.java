package com.questions.homework;

import java.util.Scanner;

public class InterestExample_17 {
	
	//Interest = Principal* Rate* Time
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Let's calculate your interest. Enter principal $ amount.");
        float Principal = sc.nextFloat();

        System.out.println("Enter percent rate");
        float Rate = sc.nextFloat();
        
        System.out.println("Enter months until payment.");
        float Months = sc.nextFloat();
        sc.nextLine();
        
        float Interest = (Principal * Rate * Months);// take all inputs, and calculate
        System.out.println("You owe: $" + Interest);

	}

}
