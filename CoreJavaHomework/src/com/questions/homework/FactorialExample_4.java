package com.questions.homework;

import java.util.Scanner;

public class FactorialExample_4 {
	
	private static Scanner sc;

	public static void main(String[] args) {
		System.out.println(runFact());
	}
	
	public static int runFact() {
		sc = new Scanner(System.in);
		System.out.println("How many numbers?");
		int N = sc.nextInt();
		sc.nextLine();
		
		int temp = N;
		
		for(int i = 1; i < temp; i++) {// first num of a factorial is always 1, go through sequential order and do recursive multiplication
			//System.out.println("test");
			N=N*i;
		}
		return N;
		
		
	}


}
