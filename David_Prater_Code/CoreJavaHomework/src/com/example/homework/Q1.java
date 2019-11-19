package com.example.homework;

public class Q1 {

	// This method takes in an int array and returns a an array sorted greatest to
	// least
	int[] bubbleSort() {

		// Perform a bubble sort on the following
		// integer array: 1,0,5,6,3,2,3,7,9,8,4
		int[] bubbleArray = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		
		// Loop the length of the array - 1 because there is nothing
		// to the "right" of the final element to compare with
		for (int i = 0; i < bubbleArray.length - 1; i++) {

			// Nested for loop to get the element to the "right" of the current element
			for (int j = i + 1; j < bubbleArray.length; j++) {

				// If statement to determine if if the current element is greater than
				// the next element
				if (bubbleArray[i] > bubbleArray[j]) {
					// Create temporary variable to store the current value of i
					int temp = bubbleArray[i];
					// Swap the values of i and j
					bubbleArray[i] = bubbleArray[j];
					bubbleArray[j] = temp;

				}

			}

		}

		// Print sorted array
		for(int i : bubbleArray) {
			System.out.print(i + " ");
		}
	
		// Return the sorted array
		return bubbleArray;

	}

}
