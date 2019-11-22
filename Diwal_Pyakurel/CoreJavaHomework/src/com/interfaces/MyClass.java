package com.interfaces;

public class MyClass implements OperationInterface{

	@Override
	public double addition(double a, double b) {
		// TODO Auto-generated method stub
		return a+b;
	}

	@Override
	public double substraction(double a, double b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	@Override
	public double multiplication(double a, double b) {
		// TODO Auto-generated method stub
		return a*b;
	}

	@Override
	public double divison(double a, double b) {
		// TODO Auto-generated method stub
		return a/b;
	}

}
