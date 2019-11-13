package com.example.homework;

public class Q1 {

	// Perform a bubble sort on the following 
	// integer array:  1,0,5,6,3,2,3,7,9,8,4
	
	int[] bubbleArray = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
	
	int[] bubbleSort(int[] bubbleArray) {
		
		int temp;
		for (int i = 0; i < bubbleArray.length - 1; i++) {

			for (int j = i + 1; j < bubbleArray.length; j++) {

				if (bubbleArray[i] > bubbleArray[j]) {
					temp = bubbleArray[i];
					bubbleArray[i] = bubbleArray[j];
					bubbleArray[j] = temp;

				}

			}

		}
		
		System.out.println(bubbleArray);
		return bubbleArray;
		
	}
	
}
