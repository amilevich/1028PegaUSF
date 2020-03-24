package com.example.bubblesort;

public class MyClass {
	/*
	 * 
	 * Bubble sort is a simple and slow sorting algorithm that repeatedly performs
	 * comparison of adjacent elements and swaps them if they are in the wrong
	 * order.
	 * 
	 * The basic idea can be described: 1. take 2 adjacent elements 2. compare said
	 * elements 3. if the first is greater than the second and we are ordering from
	 * least to greatest -> swap them if they're first is less than the second and
	 * we are ordering form least to greatest -> leave them
	 */
	public static void main(String[] args) {

		int arr[] = { 10, 20, 7, 5, 52, 3, 42 };
		// print array method called here for original array
		printArray(arr);
		System.out.println();
		// bubble sort called here
		bubbleSort(arr);
		// print array method called here for sorted array
		printArray(arr);
		System.out.println();
		
		
		int arr2[] = { 10, 20, 7, 5, 52, 3, 42 }; //same as above array to give enhanced a chance to sort it
		bubbleSortEnhanced(arr2);
		printArray(arr2);
	}

	public static void bubbleSort(int arr[]) {

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	public static void bubbleSortEnhanced(int arr[]) { 
		{ 
		   int i, j; 
		   boolean swapped; 
		   for (i = 0; i < arr.length-1; i++) 
		   { 
		     swapped = false; 
		     for (j = 0; j < arr.length-i-1; j++) 
		     { 
		        if (arr[j] > arr[j+1]) 
		        { 
		        	int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j + 1] = temp; 
		           swapped = true; 
		        } 
		     } 
		  
		     // IF no two elements were swapped by inner loop, then break 
		     if (swapped == false) 
		        break; 
		   } 
		} 
		  
	}

	public static void printArray(int arr[]) {
		for (int i : arr) {
			System.out.print(i + ", ");
		}
	}
}
