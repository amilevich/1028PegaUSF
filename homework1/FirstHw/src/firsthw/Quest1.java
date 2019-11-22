package firsthw;

public class Quest1 {

	public static void main(String[] args) {
		int arr[] = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };

		printArray(arr);
		bubbleSort(arr);
		System.out.println("Sorted array: ");
		printArray(arr);

	}

	public static void bubbleSort(int arr[]) {
		int temp;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

	}

	public static void printArray(int arr[]) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

}
