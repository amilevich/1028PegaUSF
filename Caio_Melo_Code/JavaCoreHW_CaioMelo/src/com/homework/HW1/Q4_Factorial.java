package com.homework.HW1;

//Q4 - Recursive method for solving Factorial to the number of the passed parameter.

public class Q4_Factorial {
	public static void main(String[] args) {
		
		System.out.println("Factorial of 4: " + fact(4));
		
	}
	
	public static int fact(int x) {
		if(x==1) { //Base case, return 1;
			return x; 
		}
		else {
			return x*fact(x-1); //Call fact method with decrementing number to be multiplied
			
		}
		
	}

}
