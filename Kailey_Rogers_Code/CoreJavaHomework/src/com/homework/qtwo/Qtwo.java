package com.homework.qtwo;

public class Qtwo {

	public static void main(String[] args) {

		System.out.print(n1 + " " + n2);
		printFibo(25);

	}

public static int n1 = 0, n2 = 1;
	
	public static void printFibo(int count) {
		if (count > 0) {  //&& means both conditions must be met
		int n3 = n1 + n2; //n3 = 1  n3 = 3
		n1 = n2; //n1 = 1  			n1 = 2 
		n2 = n3; //n2 = 2			n2 = 3
		System.out.print(" " + n3);
		printFibo(count-1);
		}
	}

	public static int factorial(int n) {
		if( n == 1){
			return 1;
		}
		else {
			return(n * factorial(n-1));
		}
	}
}

