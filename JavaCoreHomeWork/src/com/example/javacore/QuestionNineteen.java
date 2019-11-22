package com.example.javacore;
/*
 * Create an ArrayList and insert integers 1 through 10. 
 *  Display the ArrayList. Add all the even numbers up and display the result.
 *   Add all the odd numbers up and display the result. Remove the prime numbers
 *    from the ArrayList and print out the remaining ArrayList.
 */
import java.util.ArrayList;
import java.util.Arrays;

public class QuestionNineteen {

	public static void main(String[] args) {
		// creating an array type integer 
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		for(int i = 1; i <= 10; i++)
			arrList.add(i);// storing each elements 
		
		int sumOfEven = 0;
		int sumOfOdd = 0;
		for(int n : arrList) {//iterating through the array
			if(n % 2 == 0) //checking if n = to an even number and adding them
				sumOfEven = sumOfEven + n;
				else
					sumOfOdd = sumOfOdd + n;// checking for odds numbers and adding it
		}
		
		System.out.println("Here is the list of numbers: " + Arrays.toString(arrList.toArray()));// printing out all the elements of the array
		System.out.println("Sum of even numbers: " + sumOfEven);// printing the sum of even numbers
		System.out.println("Sum of odd numbers: " + sumOfOdd);//printing the sum of odd numbers
		
		System.out.println();
		System.out.println("Removing prime numbers: ");
		for(int i = 0; i <= 10; i++) {
			if(isPrime(i)) {// checking if there are prime numbers 
				arrList.remove(new Integer(i));// removing prime numbers from the array
			}
		}
			
		System.out.println("Here is the list of the rest numbers from the array: " + Arrays.toString(arrList.toArray()));
	
	}
	
	public static boolean isPrime(int n) {
		// prime numbers
		if(n % 2 == 0) {
			return false;
		}
		int i, m = 0;
		m = n / 2;
		for(i = 2; i <= m; i++) {
			if( n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
