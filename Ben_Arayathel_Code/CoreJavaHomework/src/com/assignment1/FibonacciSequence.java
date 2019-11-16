package com.assignment1;

public class FibonacciSequence {
	
	public static void PrintList(int[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println("");
	}
	
	public static void PrintFibonacci(int upto) {
		
		int fibNumber = upto;
		int[] fibArray = new int[fibNumber];
		
		fibArray[0] = 0;
		fibArray[1] = 1;
		
		for(int i = 2;i < fibNumber;i++) {
			fibArray[i] = fibArray[i-1]+ fibArray[i-2];
		}
		
		PrintList(fibArray);
		
	}
	
	public static void main(String[] args) {
		
		PrintFibonacci(25);
	}
	

}
