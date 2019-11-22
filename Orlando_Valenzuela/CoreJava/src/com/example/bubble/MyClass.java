package com.example.bubble;

import java.lang.Integer;

public class MyClass {
	public static void main(String[] args) {
		
		Integer []a = {1,0,5,6,3,2,3,7,9,8,4};
		
		for(int i = 0; i < a.length;System.out.print(a[i]), i++);
			
		bubble (a);
		
		System.out.print("------------");
		for(int i = 0; i < a.length;System.out.print(a[i]), i++);

    }
	
	private static void bubble (Integer []a) {
		
		for(int i = 0, t; i < a.length -1; i++)
			for(int j = i + 1; j < a.length; j++) 
				if (a[i] > a[j]) {
					t = a[i];
					a[i] = a[j];
					a[j] = t;					
				}	

	}
}
	
