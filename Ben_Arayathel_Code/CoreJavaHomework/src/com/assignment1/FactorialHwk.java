package com.assignment1;

import java.util.Scanner;

public class FactorialHwk {
	
	public static void factorial() {
		System.out.println("Please input what integer you would like a factorial for!");
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		int factorial = 1;
		
		for(int i = 1;i<=N;i++) {
			factorial = factorial*i;
		}
		System.out.println(factorial);
		in.close();
	}
	
	public static void main(String[] args) {
		
		factorial(); //calls on my factorial method
		
	}	

}
