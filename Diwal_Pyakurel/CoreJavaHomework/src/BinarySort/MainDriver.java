package BinarySort;

public class MainDriver {

	public static void main(String[] args) {

		int[] array = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		bubbleSort(array);
		
		print(array);

	}

	// Bubble Sort

	public static void bubbleSort(int[] array) {
		// creating a temp to store the variable so that we can swap
		int temp;
		// first for loop to iterate through each elements
		// Also, the number of iteration is reduced by 1 so that the nested for loop
		
		for (int i = 0; i < array.length - 1; i++) {
			// Nested for loop to iterate through all the elements with reference to single
			// element
			for (int j = i + 1; j < array.length; j++) {
				// Comparing two adjacent elements
				if (array[i] > array[j]) {
					// Swapping the adjacent elements
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}

	}

	// this function will print the elements of array
	public static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}

	}

}
