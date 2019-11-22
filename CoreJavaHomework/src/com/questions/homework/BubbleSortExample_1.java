package com.questions.homework;

public class BubbleSortExample_1 {
	
	public static void main(String[] args) {
		
		int bub[] = {1,0,5,6,3,2,3,7,9,8,4};
		
		printBub(bub);
		bubbleSort(bub);
		System.out.println("Bubble sorted: ");
		printBub(bub);
	}
	
	public static void bubbleSort(int bub[]) {//Go through int array, compare each value, swap lesser value to sorted order into temp value, and iterate through
		int temp;
		for(int i = 0; i < bub.length - 1; i++) {
			for(int x = i + 1; x < bub.length; x++) {
				if(bub[i] > bub[x]) {
					temp = bub[i];
					bub[i] = bub[x];
					bub[x] = temp;
				}
			}
		}
		
		
	}
	
	public static void printBub(int bub[]) {
		for(int i : bub) {
			System.out.print(i + " ");
		}
	}
}
