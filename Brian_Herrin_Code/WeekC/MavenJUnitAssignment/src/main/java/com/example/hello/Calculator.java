package com.example.hello;

public class Calculator {
	public boolean isTwoIntegersEqual(int i, int j) {
		if(i == j) {
			return true;
		} else {
			return false;
		}
	}
	
	public int sum(int i, int j){
		return i + j;
	}
	
	public int subtract(int i, int j){
		return i - j;
		
	}
	
	public int multiplication(int i, int j){
		return i*j;
		
	}
	
	public int division(int i, int j) {
		return i/j;
	}
	
	public double division(double i, double j) {
		return i/j;
	}
	
	public double squareRoot(double i) {
		return Math.sqrt(i);
	}
	
	public double exponents(double i, double j) {
		return Math.pow(i, j);
	}
}
