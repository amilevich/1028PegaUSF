package com.example.factorial;

public class MyClass {

	public static void main(String[] args) {

      System.out.print(factorial(5));

	}
	
	public static int factorial(int n) {
	  if (n == 1)
		 return 1;
	  else
		  return n*factorial(n-1);
	}

}
