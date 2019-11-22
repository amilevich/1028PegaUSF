package com.questions.homework;

public class FibonacciExample_2 {
	
	static int f1 = 0;
	static int f2 = 1;
	
	public static void main(String[] args) {
		printNums(15);
	}
	
	public static void printNums(int fibo) {
		if(fibo > 0) {
			int f3 = f1 + f2; // 3rd Fibo, next number
			f1 = f2;// 1st Fibo value, will be the number added to current
			f2 = f3;// 2nd fibo / current index
			System.out.print(" " + f3);// keep adding until we get Fibo. of 15
			printNums(fibo-1);// go through the count established in printNums
		}
	}

}
