package com.example.bubblesort;

public class MyClass {
	/*
	 * Bubble Sort is a simple and slow sorting algorithm that repeatedly performs comparison of adjacent elements and swaps them if they are in the wrong order. 
	 * 
	 * The basic idea can be described:
	 * 1) Take two adjacent elements
	 * 2) compare said elements
	 * 3) If the first is greater than the second and we are ordering from least to greatest -> we swap them
	 * 	  If the first is less than the second and we are ordering from least to greatest -> leave them 
	 */

	public static void main(String[] args) {

		int arr[] = {10,20,7,5,52,3,42};
		//bubble sort called here
		
		printArray(arr);
		bubbleSort(arr);
		System.out.println("\n Sorted Array: ");
		printArray(arr);
		//print array method called here
	
	}

	public static void bubbleSort(int arr[]) {
		
		int temp;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp; // array[j] = arr[i];
				}
			}
		}
	}
	
	public static void printArray(int arr[]) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
}
