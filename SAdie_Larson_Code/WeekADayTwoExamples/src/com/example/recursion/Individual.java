package com.example.recursion;

public class Individual {
	
//	public static int fact(int n)
//	{
//	    if (n <= 1) // base case
//	        return 1;
//	    else    
//	        return n*fact(n-1); //will call back to factorial but subtract 1 so decrement it   
//	}
//	
//	public static void main(String[] args) {
//		int factorialValue = fact(3);
//		System.out.println(factorialValue);
//	}
//	
	
	public static void printFun(int test) 
	{ 
	    if (test < 1) 
	        return; 
	    else
	    { 
	        System.out.println(test + " "); 
	        printFun(test-1);    // statement 2 
	        System.out.println(test + " "); 
		        return; 
	    } 
	} 
	
	public static void main(String[] args) {
	    int test = 3; 
	    printFun(test); 
	} 
}
