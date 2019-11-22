package com.homework.Qfour;

import java.util.Scanner;

public class Factorial {
	

	public static int factorialn(int temp) {
	
		if(temp == 0) 
			return 1;
			//returns the number previous to the current number in the function aagain
		return temp*factorialn(temp -1);
	}
	
	public static void main(String[] args) {
		
		System.out.println("Please enter a number from : ");
		Scanner sc = new Scanner(System.in);
	 	int value = sc.nextInt();
	 	//int temp;
	 	
	 	// call the function to begin
	 	int FinalValue = factorialn(value);
	 		
	 		System.out.println("The answer for the factorial is: " + FinalValue);
	 	
	 	sc.close();
	 	
	}

}
