package com.Q11;

public class Q11 {
	
		
	public static void main (String[] args) {
		
		//Q11. Write a program that would access two float-variables from a class that exists in another package. Note, you will need to create two packages to demonstrate the solution.
		
		     TwoFloat obj = new TwoFloat(6.7f,5);
			 System.out.println("First Float Variable: " + obj.getA() + " Second Float Variable: " + obj.getB());
	}
}

