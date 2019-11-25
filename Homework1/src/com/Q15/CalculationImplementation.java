package com.Q15;

public class CalculationImplementation implements Calculation{

	//OVERRIDDEN METHODS TO IMPLEMENT BODY 
	
	@Override
	public int addition(int a, int b) {
		return a+b;
	}

	@Override
	public int subtraction(int a, int b) {
		return a-b;
	}

	@Override
	public int multiplication(int a, int b) {
		return a*b;
	}

	@Override
	public double division(int a, int b) {
		return a/b;
	}
}
