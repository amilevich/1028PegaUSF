package com.homework;

public class Substring5 
{
	public static void main(String[] args) 
	{
		String text = "wezrxctbjmk";
		int n = 7;
		System.out.println("input string: " + text + "\ninput number: " + n + "\nOutput: " + substring(text,n));
		
	}
	
	static String substring(String _text, int _num)
	{
		char[] temp = new char[_num];
		
		for(int i = 0; i < _num; i++)
		{
			temp[i] =_text.charAt(i);
		}
		
		return new String(temp);
	}
}
