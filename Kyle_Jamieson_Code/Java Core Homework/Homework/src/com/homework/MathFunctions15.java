package com.homework;

public class MathFunctions15 implements  MathInterface15 
{
	//Q15. Write a program that defines an interface having the following 
	//methods: addition, subtraction, multiplication, and division.  Create 
	//a class that implements this interface and provides appropriate functionality 
	//to carry out the required operations. Hard code two operands in a test 
	//class having a main method that calls the implementing class.
	
	public static void main(String[] args) 
	{
		double dInput1 = 5.8, dInput2 = 9.1;
		MathFunctions15 math = new MathFunctions15();
		
		System.out.print("Input 1: " + dInput1 + "\nInput 2: " + dInput2 + "\nAddition: " + math.addition(dInput1, dInput2) +
				"\nSubtraction: " + math.subtraction(dInput1, dInput2) + "\nMultiplication: " + math.multiplication(dInput1, dInput2) +
				"\nDivision: " + math.division(dInput1, dInput2) + '\n');

	}
	
	public double addition(double _input1, double _input2)
	{
		return _input1 + _input2;
	}
	
	public double subtraction(double _input1, double _input2)
	{
		return _input1 - _input2;
	}
	
	public double multiplication(double _input1, double _input2)
	{
		return _input1 * _input2;
	}
	
	public double division(double _input1, double _input2)
	{
		return _input1 / _input2;
	}

}
