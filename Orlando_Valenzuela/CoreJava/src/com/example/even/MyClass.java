package com.example.even;

public class MyClass {

	public static void main(String[] args) {
		
		System.out.print(even(11));
	}
	
	private static boolean even(int n) {
		
		double aux1 = n;
		
		return aux1/2 == n/2;
		
	}

}
