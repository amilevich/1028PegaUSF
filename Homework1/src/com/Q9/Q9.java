package com.Q9;

import java.util.ArrayList;

public class Q9 {
	
	public static void main(String[] args) {
	
		CheckPrime();
	}
	
	 //Q9. Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.	 // Q12. Write a program to store numbers from 1 to 100 in an array. Print out all the even numbers from the array. Use the enhanced FOR loop for printing out the numbers.
		static void CheckPrime(){
			 ArrayList<Integer> arraylist = new ArrayList<Integer>();
			 int i=1;
			 int k=2;
			 while (arraylist.size() < 100) {
				 arraylist.add(i);
				 i++;
			 }
			 System.out.println("Original Array: " + arraylist);
			 for(Integer y: arraylist) {
				//Prime number generator
				 boolean flag = false;
			        while(k <= y/2)
			        {
			            // condition for nonprime number
			            if(y % k == 0)
			            {
			                flag = true;
			                break;
			            }
			            ++k;
			        }
			        if (!flag)
			            System.out.println(y + " is a prime number.");
			        else
			            System.out.println(y + " is not a prime number.");
			 }
		 }
}
