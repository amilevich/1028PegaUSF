package com.homework;

public class CommandLine16 
{
	public static void main(String[] args) 
	{
//		System.out.println("Command line args: " + args);
		//blacksheep
		//1234567890
		if(args.length >= 0)
		{
			String input = args[args.length-1];
			System.out.println("Character count: " + countChars(input));
		}
	}
	
	static int countChars(String _input)
	{
		return _input.length();
	}

}
