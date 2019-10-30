package com.generatearray;

import java.util.Random;

public class FirstTry {
	
	public static int[] BubbleSort(int[] list) {
		
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
	
	public static void main(String[] args) {
		
		int length_array = 10;
		
		int[] int_array = new int [length_array];
		
		for (int i = 0;i<length_array;i++){
			Random r = new Random();
			int_array[i] = r.nextInt(10);
		}
		System.out.println("Initial list");
		PrintList(int_array);
		System.out.println("Sorted list");
		PrintList(BubbleSort(int_array));
		
	}

}
