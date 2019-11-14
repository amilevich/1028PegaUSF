package com.assignment1;

public class Q13 {
	public static void main(String[] args) {
		
		int c = 0;
		
		int sum = 7;
		
		for(int i = 1;i<sum;i++){
			
			for(int j = 0 ; j<i; j++) {
				System.out.print(c + " ");
				c = (c == 0)?1:0;
			}
			System.out.println("");
			
		}
	}

}
