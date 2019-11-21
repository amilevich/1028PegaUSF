package Q1BubbleSort;

public class BubbleSort {

	public static void main(String[] args) {
		//Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
		
		int arr[] = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		
		System.out.print("\nThe original array is: ");
		printAray(arr);
		
		arr = bubble(arr);
		
		System.out.print("\n\nThe sorted   array is: ");
		printAray(arr);

	}
	
	private static void printAray(int[] a) {
		for (int i = 0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}	
	}

	static int[] bubble(int[] a) {
		int temp;
		
		for (int i = 0; i < a.length-1; i++) {
			for (int j = i+1; j < a.length; j++) {
				if (a[i]>a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		return a;
	}
}
