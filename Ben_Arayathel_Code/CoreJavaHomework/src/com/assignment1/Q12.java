package com.assignment1;

public class Q12 {
	
	public static void main(String[] args) {
		int[] numberList = new int[100];
		int i = 0;
		while(i<100) {
			numberList[i] = i;
			i++;
		}
		
		for(int j:numberList) {
			if(j%2 == 0) {
				System.out.print(j + " ");
			}
		}
	}

}
