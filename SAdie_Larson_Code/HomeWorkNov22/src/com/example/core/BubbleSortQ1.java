package com.example.core;
//DONE
/*
 * Perform a bubble sort on the following 
 * integer array:  1,0,5,6,3,2,3,7,9,8,4
 */
public class BubbleSortQ1 {

	public static void main(String[] args) {
		int[] intArray = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		bubbleSort(intArray);
		printArray(intArray);
	}

	public static void printArray(int[] num) {
		for (int i = 0; (i < num.length - 1); i++) {
			System.out.print(num[i] + ", ");
		}
		System.out.println(num[num.length - 1]);
	}

	public static void bubbleSort(int[] num) {
		for (int i = 0; i < num.length - 1; i++) {
			for (int j = i+ 1; j < num.length; j++) {
				if (num[i] > num[j]) {
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
	}

}
