package interview.questions;

public class QOne {
	
	public static void main(String[] args) {
		int arr[] = {1,0,5,6,3,2,3,7,9,8,4};
		bubbleSort(arr);
		printArray(arr);
	}
	
	public static void bubbleSort(int arr[]) {
		int temp;
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = i + 1; j < arr.length;j++) {
				if(arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp; //arr[j] = arr[i]
				}
			}
		}
		
	}
	
	public static void printArray(int arr[]) {
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}

}
