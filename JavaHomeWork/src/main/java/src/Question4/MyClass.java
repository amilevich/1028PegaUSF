package src.Question4;
/*
 * Write a program to compute N factorial.
 */

public class MyClass {
	
	public static int factorial(int n) // method to find factorial of given number 
	{
		if (n == 0)
			return 1;
		return n*factorial(n-1);
	}
	public static void main(String[] args) {
		int num = 7;
		System.out.println("The factorial of " + num + " is " + factorial(7));
	}
	
}
