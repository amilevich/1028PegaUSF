package com.example.bubblesort;

public class MyClass {
	/*
	 * Bubble sort is a simple and slow sorting algorithm that 
	 * repeatedly performs comparison of adjacent elements and swaps them if they are in the wrong order
	 * 
	 * the basic idea can be described:
	 * 1) Take two adjacent elements
	 * 2) compare said elements
	 * 3) if the first is greater than the second and we are ordering form least to greatest -> swap
	 * if the first is less than the second and we are ordering from least to greatest -> leave them
	 * */
	public static void main(String[] args) {
		int arr[] = {10,20,7,5,52,3,42};
		//bubble sort called here
		//print array method called here
		printArray(arr);
		bubbleSort(arr);
		System.out.print("sorted array: ");
		printArray(arr);
		
}
	public static void bubbleSort(int arr[]) {
		int temp;
		for(int i =0; i < arr.length-1; i++) {
			for(int j = i + 1; j < arr.length;j++) {
				if(arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp; //arr[j] = arr[i]
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
