package com.javahomework.questions;

public class QuestionOneClass {
	public static void main(String[] args) {
		/*
		 *  Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
		 * */
		int arr[] = {1,0,5,6,3,2,3,7,9,8,4};
		System.out.println("unsorted array: ");
		printArray(arr);
		bubbleSort(arr);
		System.out.println(" Sorted Array: ");
		printArray(arr);

	}
	//below i am making the bubble sort method
	//that takes an argument of integer array
	public static void bubbleSort(int[] myArray) {
		int temp;
		for(int i = 0; i < myArray.length - 1; i++) {
			for(int j = i + 1; j < myArray.length; j++) {
				if(myArray[i] > myArray[j]) {
					temp = myArray[i];
					myArray[i] = myArray[j];
					myArray[j] = temp;
				}
			}
		}
	}
	//here below i am making the method to show the array
	//to the console once this method is called
	public static void printArray(int[] myArray) {
		for(int i : myArray) {
			System.out.println(i + " ");
		}
	}
}
