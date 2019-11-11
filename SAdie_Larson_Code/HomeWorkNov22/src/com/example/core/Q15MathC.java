package com.example.core;

public class MathC implements MathI {

	@Override
	public int addition(int x, int y) {
		return x+y;
	}

	@Override
	public int division(int x, int y) {
		return x/y;
	}

	@Override
	public int subtraction(int x, int y) {
		return x-y;
	}

	@Override
	public int multiplication(int x, int y) {
		return x*y;
	}
	

}
