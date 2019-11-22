package com.homework;

public class BubbleSort1 
{
	public static void main(String[] args) 
	{
		int [] nArray = {1,0,5,6,3,2,3,7,9,8,4};
		for(int i = 0; i < nArray.length; i++)
		{
			System.out.print(nArray[i]);
			if(i < nArray.length-1)
				System.out.print(", ");
		}
		System.out.print('\n');
		System.out.println("Sorting");
		nArray = BubbleSort1.sort(nArray);
		for(int i = 0; i < nArray.length; i++)
		{
			System.out.print(nArray[i]);
			if(i < nArray.length-1)
				System.out.print(", ");
		}
		System.out.print('\n');
		
	}
	public static int[] sort(int[] _input)
	{
		int[] temp = new int[_input.length];
		temp = _input;
		
		for(int i = 0; i < temp.length-1; i++)
		{
			for(int j = 0; j < temp.length-i-1; j++)
			{
				if (temp[j] > temp[j+1])
				{
					int nBuffer = temp[j];
					temp[j] = temp[j+1];
					temp[j+1] = nBuffer;
				}
			}
		}
		
		return temp;
	}
}
