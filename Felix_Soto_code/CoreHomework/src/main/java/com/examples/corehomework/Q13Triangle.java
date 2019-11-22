package com.examples.corehomework;

public class Q13Triangle {

	public static void main(String[] args) {

		int a = 0, b = 1, c = 0;
		for(int i = 0; i < 4; i++) {
			for(int q = 0; q <= i; q++) {
				if(c == 0) {
					System.out.print(a + " ");
					c = b;
				}else if(c == 1) {
					System.out.print(b + " ");
					c = a;
				}
			}
			System.out.println("\n");
		}
		
	}

}
