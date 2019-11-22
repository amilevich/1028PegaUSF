package com.nfactorial;

public class NFactorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		calculateFactorial(10);
		calculateFactorial(3);
		calculateFactorial(5);
		calculateFactorial(4);

	
	}
	
	public static void calculateFactorial(int num) {
		//gets the number of times iteration has to be done as num can be changable
		int numOfiteration = num;
		//Multiplies num with i every time in a loop
		for(int i =1; i<numOfiteration;i++) {
			num = num*i;
		}
		
		System.out.println("The factorial for "+ numOfiteration + " is "+ num);	
	}

}
