package com.homework;

import java.util.Scanner;

public class Factorial4 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter whole number:");
		int nInput = sc.nextInt();
		sc.nextLine();
		
		System.out.println(nInput + "! == " + Factorial4.factorial(nInput));
		
		sc.close();
		
	}

	public static int factorial(int _input)
	{
		int nInput = 1;
		
		// Check for valid input
		if (_input <= 0)
			return 0;
		
		// Calculate the factorial
		for(int i = _input; i > 1; i--)
		{
			nInput *= i;
		}
		
		// check for overflow... if overflowed just set to max value
		if (nInput <= 0)
			nInput = Integer.MAX_VALUE;
		
		return nInput;
	}
}
