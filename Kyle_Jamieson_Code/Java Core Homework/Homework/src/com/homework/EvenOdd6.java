package com.homework;

import java.util.Scanner;

public class EvenOdd6 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("Please enter whole number:");
		int nInput = sc.nextInt();
		sc.nextLine();
		
		if (EvenOdd6.isEven(nInput))
			System.out.println(nInput + " is even");
		else
			System.out.println(nInput + " is odd");

		//ending program, shut down scanner
		sc.close();
	}
	public static boolean isEven(int _input)
	{
		// bitwise &(and) to check the right most bit. only odd numbers have bit on
		// other possible but slower method is if(x == (x*0.5)*2) == even
		return(0 == (_input&1)) ? true : false;
	}
}
