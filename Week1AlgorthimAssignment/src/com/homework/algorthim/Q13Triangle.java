package com.homework.algorthim;

public class Q13Triangle {
	
	public void triangle() {
		int size = 5;
		
		for(int i = 0; i < size+1; i++) {
			for(int j = size; j > i; j--) {
				System.out.print(" ");
			}
			for(int k = 0; k < (2*i-1); k++) {
				if(k%2==0) {
					System.out.print(0);
				} else {
					System.out.print(1);
				}
			}
			System.out.println();
		}
	}

}
