package com.homework.HW1;
import java.util.Arrays;

//Q1 - Recursive Bubble Sort of a passed array, and it's length
public class Q1_BubbleSort {
	public static void main(String[] args) {
		
	
	int[] array = {1,0,5,6,3,2,3,7,9,8,4};
	bubSort(array,array.length);
	System.out.println(Arrays.toString(array));
	
}
	
	public static void bubSort(int[] x, int y) {
		
if(y == 1) //base case, until length passed is 1
	return;

for(int i = 0; i<y-1;i++) { //itterate through the length of the area
	
	if (x[i] > x[i+1])
	{
		int temp = x[i]; //Swap variables
		x[i] = x[i+1];
		x[i+1] = temp;
		}
	bubSort(x,y-1);	//recall method with length of it decremented
	
}
		
		return;
	}

}

