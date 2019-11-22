package com.Q19;

import java.util.ArrayList;

public class Q19 {
	
	public static void main(String[] args) {
		
		int even_sum = 0;
		int odd_sum = 0;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		for(int i=1;i<=10;i++) 
			arr.add(i);
		System.out.println("Original arraylist: " + arr);
		
		for(int i:arr) {
			if(i%2==0)
				even_sum = i + even_sum;
			else
				odd_sum = i + odd_sum;
		}
		System.out.println("\nSum of even numbers in the array list is: "+ even_sum );
		System.out.println("Sum of odd numbers in the array list is: "+ odd_sum );
		
		for(int y: arr) {
			//Prime number generator
			if (y%2==0 && y>2) arr2.add(y);
		    //if not, then just check the odds up to the square root of the number in question
		    for(int i=3;i*i<=y;i+=2) {
		        if(y%i==0)
		        	arr2.add(y);
		    }
		 }
		System.out.println("\nNon Prime Numbers: " + arr2);
	}
	
}
