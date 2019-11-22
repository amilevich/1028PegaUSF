package com.example.corehomework.Q15;

import com.examples.corehomework.Q15Interface;

public class Q15MDAS implements Q15Interface{

	@Override
	public void addition(int a, int b) {
		System.out.println("Addition: " + a + " + " + b + " = " + (a+b));
		
	}

	@Override
	public void subtraction(int a, int b) {

		System.out.println("Subtraction: " + a + " - " + b + " = " + (a-b));
	}

	@Override
	public void multiplication(int a, int b) {

		System.out.println("Multiplication: " + a + " * " + b + " = " + (a*b));
	}

	@Override
	public void division(int a, int b) {

		System.out.println("Division: " + a + " / " + b + " = " + (a/b));
	}





}
