package com.enhancedforloop;

public class EnhancedForLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		printAndStroe(100);
	}
	
	public static int[] printAndStroe(int n) {
		//creating an array list to store 100
		 int[] arr = new  int[n];
		 for(int i=0; i<100; i++) {
			arr[i]=i+1;
		 }
		 
		 //enhanced loop to store even number
		 for(int i: arr) {
			 if(i%2==0) {
				 System.out.print(i+ " ");
			 }
		 }
		 
		 
		 return arr;
		
	}

}
