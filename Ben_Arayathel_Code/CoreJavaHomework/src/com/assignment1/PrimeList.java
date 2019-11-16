package com.assignment1;

import java.util.ArrayList;
import java.util.List;

public class PrimeList {
	
	public static List<Integer> createList(int length) {
		List<Integer> int_array = new ArrayList<>();
		
		for (int i = 0;i<length;i++){
			int_array.add(i);
		}
		
		return int_array;
		
	}

	public static void PrintList(int[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		
		List<Integer> newList = createList(100);
		System.out.println(newList);
		
		for (int i = 1; i<newList.size();i++) {
			for(int j = 2; j < i/2;j++ ) {
				if(i%j == 0) {
					//System.out.println("i:" + i + "j:" + j + "i%j" + i%j + " is not a prime number.");
					break;
				}
				else {
					System.out.println(i + " is a prime");
				}
			}
		}
		
		
	}

}
