package com.Q15;

public class MainClass {

	public static void main(String[] args) {
		
	
		int i = 66;
		int j = 23;
		CalculationImplementation obj = new CalculationImplementation();
		
		System.out.println("Values are: "+i+" & "+j);
		
		System.out.println("Addition: "+obj.addition(i, j));
		System.out.println("Subtraction: "+obj.subtraction(i, j));
		System.out.println("Multiplication: "+obj.multiplication(i, j));
		System.out.println("Division:"+obj.division(i, j));
		
	
	}

}
