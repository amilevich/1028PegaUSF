package com.example.selectionSort;

public class MyClass {

	public static void main(String[] args) {

		int arr[] = { 5, 10, 25, 32, 26, 13};
		selectionSort(arr);
		printArray(arr);
	}
	public static void selectionSort(int arr[])  
	{  
	    int i, j, min_idx;  
	  
	    // One by one move boundary of unsorted subarray  
	    for (i = 0; i < arr.length-1; i++)  
	    {  
	        // Find the minimum element in unsorted array  
	        min_idx = i;  
	        for (j = i+1; j < arr.length; j++) {  
	        if (arr[j] < arr[min_idx])  
	            min_idx = j;  
	        }
	        // Swap the found minimum element with the first element  
	        int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
	    }  
	}  
	
	public static void printArray(int arr[]) {
		for (int i : arr) {
			System.out.print(i + ", ");
		}
	}

}
