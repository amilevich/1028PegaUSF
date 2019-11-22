package com.homework;

import java.util.Scanner;

public class ReverseString3 
{
	public static void main(String[] args) 
	{
		// Get input
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string to reverse:");
		String data = sc.nextLine();
		
		// reverse string
		data = reverseString(data);
		
		// display updated data
		System.out.println("Reversed string: " + data + '\n');
		
		//exiting shutdown scanner
		sc.close();

	}

	static String reverseString(String _input)
	{
		int length = _input.length();
		for(int i = length-1; i>=0; i--) 
		{
			_input = _input.concat(String.valueOf(_input.charAt(i)));
		}
		
		return _input.substring(length);
	}
}


