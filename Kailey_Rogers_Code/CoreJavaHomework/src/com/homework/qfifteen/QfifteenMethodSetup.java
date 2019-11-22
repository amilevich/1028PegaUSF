package com.homework.qfifteen;

public class QfifteenMethodSetup implements QfifteenInterface{

	@Override
	public double Addition(double... add) {
		double sum = 0;
		for(double a : add) {
			sum = sum + a;
		}
		
		return sum;
	}


	@Override
	public double Multiplication(double... multiply) {
		double product = 1;
		for (double c : multiply) {
			product = product * c;
		}
		return product;
	}

	@Override
	public double Division(double divide, double divider) {
		return divide/divider;
	}


	@Override
	public double Substraction(double subtractTo, double subtractFrom) {
		return (subtractFrom-subtractTo);
	}

}
