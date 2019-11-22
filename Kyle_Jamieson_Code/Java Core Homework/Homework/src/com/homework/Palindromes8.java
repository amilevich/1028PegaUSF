package com.homework;

import java.util.ArrayList;

public class Palindromes8 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ArrayList<String> master = new ArrayList<String>();
		ArrayList<String> palindromes = new ArrayList<String>();

		// Insert data into master list
		master.add("karan");
		master.add("madam");
		master.add("tom");
		master.add("civic");
		master.add("radar");
		master.add("sexes");
		master.add("jimmy");
		master.add("kayak");
		master.add("john");
		master.add("refer");
		master.add("billy");
		master.add("did");
		
		//Collect the palindromes
		for(int i = 0; i < master.size(); i++)
		{
//			System.out.println(master.get(i));
			if(isPalindrome(master.get(i)))
			{
				palindromes.add(master.get(i));
			}
		}
		
		//print them out
		System.out.println("The palindromes are:");
		for(int i = 0; i < palindromes.size(); i++)
		{
			System.out.print(palindromes.get(i));
			if (i != palindromes.size()-1)
				System.out.print(", ");
		}
		
		
	}
	
	static boolean isPalindrome(String _input)
	{
		String temp = "";
		for(int i = _input.length()-1; i>=0; i--) 
		{
			temp += _input.charAt(i);
		}

		return temp.contentEquals(_input);
	}

}
