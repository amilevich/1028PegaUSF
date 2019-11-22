
package davidvallejo.hw.javacore;

public class Question1 {
	/*
	 * Q1: Perform a bubble sort on the following array: 1,0,5,6,3,2,3,7,9,8,4
	 * bubbleSortingArray: {1,0,5,6,3,2,3,7,9,8,4}
	 * Bubble sorted array intended outcome: 0,1,2,3,3,4,5,6,7,8,9
	 * */

	public static void main(String[] args) {
		int[] bSortThisArray = {1,0,5,6,3,2,3,7,9,8,4};
		System.out.print( "Original Unsorted Array: 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 \n");
		BubbleSortMethod(bSortThisArray);
		PrintSortedArray(bSortThisArray);
		
		
	}
	public static void PrintSortedArray(int[] array2) {//the array2 array will hold our Bubble Sorted Array
		System.out.print( "New Bubble Sorted Array: ");
		for(int i=0;(i<array2.length-1);i++) {
			System.out.print(array2[i] + ", ");
		}
		System.out.print(array2[array2.length-1]);
	}
public static void BubbleSortMethod(int[] array2) {
	for(int i =0;i < array2.length -1;i++) {
		for(int j =i+1;j<array2.length;j++) {
			if(array2[i]>array2[j])//swapping variable place in the array
			{
				int t = array2[i]; // integer variable t will hold our temporary variable 
				array2[i] = array2[j]; 
				array2[j] = t;
			}
			}
	}
}
}
