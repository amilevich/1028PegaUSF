package com.homework;

public class Triangle13 {
	

	public static void main(String[] args) 
	{
		Triangle13.printTriangle();
	}
	
	static final int size = 10;
	static void printTriangle()
	{
		int newline = 0;
		int counter = 0;
		for (int i = 0; i < size; i++)
		{
			System.out.print(((0==(i&1)) ? 0 : 1) + " ");
			if(newline == counter++)
			{
				counter = 0;
				newline++;
				System.out.print('\n');
			}
		}
	}
	

}
