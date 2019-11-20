package Q1;

public class Q1Driver {

	// Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
	public static void main(String[] args) {
		Integer[] array = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		boolean notSorted = true;
		
		System.out.printf("Unsorted array: ");
		for(int i = 0; i < array.length; i++) System.out.printf("%d ", array[i]);
		System.out.printf("\n");
		
		while(notSorted) {
			notSorted = false;
			//iterate through array
			for(int i = 0; i < array.length - 1; i++) {
				//if adjacent elements are unsorted, swap them
				if(array[i] > array[i+1]) {
					array[i] ^= array[i+1];
					array[i+1] ^= array[i];
					array[i] ^= array[i+1];
					notSorted = true;
				}
			}
		}
		
		System.out.printf("Sorted array: ");
		for(int i = 0; i < array.length; i++) System.out.printf("%d ", array[i]);
		System.out.printf("\n");
	}
}
