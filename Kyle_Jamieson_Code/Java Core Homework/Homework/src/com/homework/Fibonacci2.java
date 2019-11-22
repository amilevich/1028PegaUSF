package com.homework;

public class Fibonacci2 
{
	public static void main(String[] args) 
	{
		print25();
	}
	public static void print25()
	{
		int num = 25;
		for(int i = 0; i < num; i++)
		{
			System.out.print(fib(i));
			if(i != num-1)
				System.out.print(", ");
		}
	}
	public static int fib(int _input)
	{
		if (_input <= 1) 
	    	return _input; 
		return fib(_input-1) + fib(_input-2); 
	 }
}
