package com.assignment1;

public class EvenChecker {
	
	public static boolean evenChecker(int n) {
		if(n == 1) {
			System.out.println("It's 1 mate");
			return false;
		}else if(n <0) {
			System.out.println("I only look at the positive side of things");
			return false;
		}
		while(n>0) {
			n -= 2;
			if(n == 1) {
				System.out.println("number is odd");
				n = 0;
				return false;
			}
		}
		System.out.println("number is even");
		return true;
	}
	
	public static void main(String[] args) {
		int n = -10;
		evenChecker(n);
	}

}
