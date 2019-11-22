package com.homework.qseventeen;

import java.util.Scanner;

public class Qseventeen {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double principle;
		double rate;
		double time;
		
		System.out.print("Please enter the principle: ");
		principle = sc.nextDouble();
		System.out.print("Please enter the rate: ");
		rate = sc.nextDouble();
		System.out.print("Please enter the time: ");
		time = sc.nextDouble();
		
		System.out.println("Interest is " + principle * rate * time);
	}

}
