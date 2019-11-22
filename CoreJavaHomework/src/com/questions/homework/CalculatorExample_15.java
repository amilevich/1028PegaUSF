package com.questions.homework;

public class CalculatorExample_15 implements CalculatorInterface{

	@Override
	public int add(int... a) {// Concrete methods to do math
		int sum = 0;
		for(int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}

	@Override
	public int sub(int a, int b){
		int sum = a - b;
		return sum;
	}

	@Override
	public int div(int a, int b) {
		int sum = a / b;
		return sum;
	}

	@Override
	public int multi(int a, int b) {
		int sum = a * b;
		return sum;
	}
	


}

