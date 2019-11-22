package com.homework;

public class Concrete18 extends BaseClass18 
{

	public static void main(String[] args) 
	{
		Concrete18 test = new Concrete18();
		
		String text = "Cat";
		String text2 = "dog";
		String text3 = "VELCRO";
		String te3xt4 = "123";
		
		System.out.println("Any uppercase in " + text + "? " + test.anyUpper(text));
		System.out.println("Any uppercase in " + text2 + "? " + test.anyUpper(text2) + '\n');
		
		System.out.println(text3 + " to lower case is " + test.toLower(text3) + '\n');
		test.toIntPlus10(te3xt4);

	}

	@Override
	public boolean anyUpper(String _input) 
	{
		for(int i = 0; i < _input.length(); i++)
		{
			if(_input.charAt(i) >= 65 && _input.charAt(i) <= 90)
				return true;
		}
		return false;
	}

	@Override
	public String toLower(String _input)
	{
		//turn string into char array
		char[] buffer = _input.toCharArray();
		
		// covert to lower
		for(int i = 0; i < buffer.length; i++)
		{
			if(buffer[i] <= 90 && buffer[i] >= 65)
				buffer[i] += 32;
		}
		
		return new String(buffer);
	}

	@Override
	public void toIntPlus10(String _input) 
	{
		int output = Integer.parseInt(_input);
		output += 10;

		System.out.println("String (" +_input + ") to int: " + output);
	}

}
