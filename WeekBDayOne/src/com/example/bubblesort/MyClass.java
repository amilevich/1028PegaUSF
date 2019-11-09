package com.example.bubblesort;

public class MyClass {
	
	/*
	 * Bubble sort is a simple and slow sorting algorithms that repeatedly perfmorsm
	 * comparison of adjacent elements and swaps them if they are in the wrong order.
	 * 
	 * the basic idea can be described:
	 *1) Take two adjacent elements
	 *2) Compare said elements
	 *3) If the first is greater than the second and we are ordering from least to greatest -> swap them
	 *
	 * If the first is less than the second and we are ordering from lesat to greatest -> leave them
	 */

	public static void main(String[] args) {

		int arr[] = {10,20,7,5,52,3,42};
		//bubble sort called here
		
		printArray(arr);
         bubbleSort(arr);
		
		System.out.println("Sorted array: ");
		printArray(arr);
		// print array method called here
		
		
	}
	
	public static void bubbleSort(int arr[]) {
		
		int temporary;// temporary variable to hold the value when swapping
		
		for(int i = 0; i < arr.length; i++) {
			
			for(int j =  i + 1; j < arr.length; j++) {
				
				if (arr[i] > arr[j]) {
					
					temporary = arr[i];
					arr[i] = arr[j];
					arr[j] = temporary;// arr[j] = arr[i]
				}
			}
		}
	}
	
	public static void printArray(int arr[]) {
		
		for(int i: arr) {
			System.out.print(i + " ");
		}
	}

}
