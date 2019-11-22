package com.homework;

public class PrintEven12 
{
	public static void main(String[] args) 
	{
		// Set up array to print
		final int nSize = 100;
		int[] nArray = new int[nSize];
		for(int i = 0; i < nSize; i++)
			nArray[i] = i+1;
		
		printEven(nArray);
	}
	
	public static void printEven(int[] _input)
	{
		System.out.println("EVEN NUMBERS:");
		int index = 0;
		for (int i : _input)
		{
			if(0 == (_input[index]&1))
				System.out.println(_input[index]);
			index++;
		}
	}
}
