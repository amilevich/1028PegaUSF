package com.homework;

import java.util.ArrayList;

public class PrimeArray9 
{
	private static final int m_arraySize = 100;

	public static void main(String[] args) 
	{
		PrimeArray9.printPrimeArray();
	}

	//Q9. Create an ArrayList which stores numbers from 1 to 100 and prints out all 
	//the prime numbers to the console.

	
	static void printPrimeArray()
	{
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		
		// fill the array
		for(int i = 0; i < m_arraySize; i++)
		{
			array.add(i+1);
		}
		
		// walk arraylist and print prime numbers
		System.out.println("All prime numbers between 0 and " + m_arraySize);
		for(int i = 0; i < m_arraySize; i++)
		{
			if(isPrime(array.get(i).intValue()))
				System.out.println(array.get(i) + ", ");
		}

	}
	
	static boolean isPrime(int _input)
	{
		
		if (_input <= 1) 
            return false; 
       
        // Check from 2 to n-1 
        for (int i = 2; i < _input; i++) 
            if (_input % i == 0) 
                return false; 
       
        return true; 		
		
		/*
		if(_input <= 2)
			return true;
		else if (_input > 2 && 1 == (_input&1))
		{
			for (int i = 2; i < _input; i++)
			{
				if(0 == _input % i)
				{
					return true;
				}
			}
			return false;
		}
		return false;*/
	}
}
