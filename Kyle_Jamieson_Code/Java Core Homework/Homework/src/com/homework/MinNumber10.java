package com.homework;

import java.util.Scanner;

public class MinNumber10 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter first whole number:");
		int nInput1 = sc.nextInt();
		sc.nextLine();

		System.out.println("Please enter second whole number:");
		int nInput2 = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Smaller of " + nInput1 + " and " + nInput2 + " is " + 
						   MinNumber10.smallNum(nInput1, nInput2));
		
		//program ending, close scanner
		sc.close();
		
	}
	public static int smallNum(int _num1, int _num2)
	{
		return (_num1 < _num2) ? _num1 : _num2;
	}
}
