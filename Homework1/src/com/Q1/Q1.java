package com.Q1;

public class Q1 {
	

		//Q1. Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
	    
		final static int[] arr = new int [] {1,0,5,6,3,2,3,7,9,8,4};
		
	    static void printArray(int arr[]) {
			for(int i : arr) {
				System.out.print(i + " "); 
			}
			System.out.println();
		}
			
	    static void bubbleSort(int arr[]) {	
			System.out.print("Bubble Sorted Array: ");
			int n = arr.length;
			for(int i = 0; i<n-1; i++)
				for(int j = i+1; j<n; j++)
					if(arr[i]>arr[j])
					{
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
			printArray(arr);
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bubbleSort(arr);
	}
}

