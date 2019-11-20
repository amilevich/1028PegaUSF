package com.assignment1;

public class Q15 implements Q15interface{

	@Override
	public double addition(double... d) {
		double sum = 0;
		for(double i:d) {
			sum += i;
		}
		return sum;
	}


	@Override
	public double multiplication(double... d) {
		double sum = 1;
		for(double i:d) {
			sum *= i;
		}
		return sum;
	}


	@Override
	public double subtraction(double a, double b) {
		return (a-b);
	}

	@Override
	public double division(double a, double b) {
		return a/b;
	}
	
	
	
	

}
