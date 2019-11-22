package com.homework.Q15;

import java.util.Scanner;

//appying 
public class SumClass implements SumInterface {

	public static void main(String[] args) {
		int num1;
		int num2;
		
		Scanner two = new Scanner(System.in);
		
		System.out.println("Please enter one number: ");
		num1 = two.nextInt();
		
		System.out.println("Please enter another number: ");
		num2 = two.nextInt();
		
		// call the methods from the interfae
		SumClass the = new SumClass();
		
		the.additon(num1,num2);
		the.subtraction(num1, num2);
		the.multiply(num1, num2);
		the.divide(num1, num2);
				
		
	}
	// 4 methods overriden from the sumInterface
	@Override
	public void additon(int value, int value2) {
		int sum;
		sum = value + value2;
		System.out.println("Additon: " + sum);
		
	}

	@Override
	public void subtraction(int value3, int value4) {
		int sum2;
		sum2 = value3 - value4;
		System.out.println("Subtraction: " + sum2);
		
	}

	@Override
	public void multiply(int value5, int value6) {
		int sum3;
		sum3 = value5 * value6;
		System.out.println("Multiply: " + sum3);
		
	}

	@Override
	public void divide(int value7, int value8) {
		int sum4;
		sum4 = value7/value8;
		System.out.println("Divide: " + sum4);
	}

	
}
