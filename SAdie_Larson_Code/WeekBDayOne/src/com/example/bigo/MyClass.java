package com.example.bigo;

public class MyClass {

	public static void main(String[] args) {
/*
 * if we have 2 or more algorithms, how do we combine 
 * big o notation?
 * 
 */
		
	}
	void running(int[] array) { //O(A) + O(B) = O(A+B) =
		int sum = 0;
		int product = 1;
		for(int i = 0; i < array.length; i++) { 
			sum =+array[i];
		}//for loop A
		
		for(int i = 0; i < array.length; i++) {
			product *= array[i];
		}// for loop B
		
		System.out.println(sum + ", " + product);
	}
	
	public void walking(int[] array) {
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array.length; j++) {
				System.out.println(array[i] + ", " + array[j]);
			}
		}
	} // the inner loop has O(N) iterations and it is called
	//N times
	//O(N*N) = O(N^2)

}
