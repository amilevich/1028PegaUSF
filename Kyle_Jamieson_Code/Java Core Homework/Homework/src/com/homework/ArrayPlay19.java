package com.homework;

import java.util.ArrayList;

public class ArrayPlay19 
{

	public static void main(String[] args) 
	{
		play();
	}
	
	static ArrayList<Integer> array = new ArrayList<Integer>();
	
	static void play()
	{
		//Q19. Create an ArrayList and insert integers 1 through 10. Display the ArrayList. Add 
		//all the even numbers up and display the result. Add all the odd numbers up and display 
		//the result. Remove the prime numbers from the ArrayList and print out the remaining ArrayList.		
		
		//build array
		int arraysize = 10;
		for(int i = 0; i < arraysize; i++)
			array.add(i);
		
		//even sum
		int sum = 0;
		int currentNumber = 0;
		for(int i = 0; i < array.size(); i++)
		{
			currentNumber = array.get(i);
			if(0 == (currentNumber&1))
				sum += currentNumber;
		}
		System.out.println("Sum of all even numbers in the array is " + sum);
		
		//odd sum
		for(int i = 0; i < array.size(); i++)
		{
			currentNumber = array.get(i);
			if(1 == (currentNumber&1))
				sum += currentNumber;
		}
		System.out.println("Sum of all odd numbers in the array is " + sum);
		
		//remove primes
		for(int i = 0; i < array.size(); i++)
		{
			if(isPrime(array.get(i)))
				array.remove(i);
				
		}
		System.out.print("Non-Prime numbers: " + array);
//		for(int i = 0; i < array.size(); i++)
//			System.out.print((int)array.get(i) + '\n');
	}

	private static boolean isPrime(int _input)
	{
		
		if (_input <= 1) 
            return false; 
       
        // Check from 2 to n-1 
        for (int i = 2; i < _input; i++) 
            if (_input % i == 0) 
                return false; 
       
        return true; 		
	}
}