package com.example.bigo;

public class MyCLass {

	public static void main(String[] args) {

		/*
		 * if we have two or more algorithms. how do we combine
		 * Big O notation?
		 * 
		 */
	
	
	}

	void running(int[] array) {// O(A) + O(B) = O
		int sum = 0;
		int product = 1;
		
		for(int i = 0; i < array.length; i++) {
			sum =+ array[i];
		}
	}
	
	public void walking(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for(int j = 0; j < array.length; j++) {
				System.out.println(array[i] + "," + array[j]);
			}
		}
	}// the inner for loop has O(N) iterations and it is called 
	//N times
	//O(
}
