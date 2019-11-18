package com.homework.algorthim;


public class Q1BubbleSort {

	// Q1. Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
	public void bubbleSort(int [] array) {
		int a = array.length;
		int temp = 0;
		for(int i = 0; i < a; i++) {
			for(int j = 1; j < a; j++) {
				if(array[j-1] < array[j]) {
					temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}
			}
		}
		
	}

}
