package com.homework.Q1;

public class Ozuna {
	

	public static void main(String[] args) {
		int num[] = {1,0,5,6,3,2,3,7,9,8,4};
		
		bubbleSort(num);
		
		for(int i=0; i< num.length; i++) {
			System.out.print(num[i] + " ");
		}
		
	}
	// Function that checks the nummber next ot it to see which is the smalles
	public static void bubbleSort(int[] bote) {
	 int temp = 0;
	 
	 for(int i = 0; i < bote.length; i++) {
		 for(int j=1; j < (bote.length-i) ; j++) {
			 // if the next number is previous number is larger than current, the swap
			 if(bote[j-1] > bote[j]) {
				 temp= bote[j-1];
			 	 bote[j-1] = bote[j];
			 	 bote[j] = temp;
			 }
		 }
	 }
		
	}
}
