package com.Q6;

public class Q6 {
	
	//Q6. Write a program to determine if an integer is even without using the modulus operator (%)
	 
		static void isEven(int num) {
			 int rem = num/2;
			 System.out.print("Is Even Method: ");
			 if(rem*2==num)
				 System.out.println("Even Number");
			 else
				 System.out.println("Odd Number");
		 }
	
	public static void main(String[] args) {
			
		isEven(4);
	}
}
