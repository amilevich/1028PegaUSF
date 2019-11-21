package src.Question1;
/*
 * Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
 */

public class MyClass {

	public static void main(String[] args) {
		int array[] = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		printArray(array);
		bubbleSort(array);
		System.out.println("Sorted array: ");
		printArray(array);
	}
	
	//implementation of Bubble Sort 
	private static void bubbleSort(int[] array) {
		int temp;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}
	//Prints the array
	private static void printArray(int[] array) {
		for (int i : array) {
			System.out.println(i + " ");
		}
	}
}
