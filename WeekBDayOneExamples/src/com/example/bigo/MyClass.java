package com.example.bigo;

import java.lang.reflect.Array;

public class MyClass {
	
	public static void main(String[] args) {
		
		
		
	}
	public void running(int[] arrray) {
		int sum = 0;
		int product = 1;
		for(int i = 0; i<arrray.length; i++) {
			sum=+arrray[i];
		}
		for(int i =0; i<arrray.length; i++) {
			product *= arrray[i];
		}
		System.out.println(sum + ", " + product);
	}
	public void walking(int[] array) {
		for(int i =0; i<array.length;i++) {
			for(int j=0; j<array.length;j++) {
				System.out.println(array[i] + ", " + array[j]);
			}
		}
	}
}
