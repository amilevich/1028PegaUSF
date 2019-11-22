package com.example.mathinterface;

public class MathOpImp implements MathOp{

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
	public int division(int a, int b) {
		
		return (b != 0)?a/b:0;
	}

}
