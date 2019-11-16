package com.assignment1;

import java.util.Random;

public class BubbleSort {
	
	public static int[] BubbleSorter(int[] list) {
		
		for (int i = 0; i < list.length; i++) {
			int dummyVariable = 0;
			for (int j = 0; j < list.length - 1; j++) {
				if(list[j] > list[j+1]) {
					dummyVariable = list[j];
					list[j] = list[j+1];
					list[j+1] = dummyVariable;
				}else {
					continue;
				}
			}
			//PrintList(list);
		}
		return list;
	}
	
	public static void PrintList(int[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println("");
	}
	
	public static int[] createList(int length) {
		int[] int_array = new int[length];
		
		for (int i = 0;i<length;i++){
			Random r = new Random();
			int_array[i] = r.nextInt(10);
		}
		
		return int_array;
		
	}
	
	public static void main(String[] args) {
		PrintList(BubbleSorter(createList(10)));	

	}
}
