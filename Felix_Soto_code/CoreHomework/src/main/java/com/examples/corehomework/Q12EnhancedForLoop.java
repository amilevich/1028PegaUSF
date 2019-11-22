package com.examples.corehomework;

public class Q12EnhancedForLoop {

	public static void main(String[] args) {

		int [] even = new int[102];
		for(int i = 1; i < even.length; i++) {
			even[i] = i;
		}
		
		for(int a : even) {
			if(even[a] % 2 == 0) {
				System.out.println(a);
			}
		}	
	}
}