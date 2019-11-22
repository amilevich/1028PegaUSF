package com.example.evenoddprime;

import java.util.ArrayList;

public class MyClass {

	public static void main(String[] args) {
		
		int se = 0, so = 0;
		
		ArrayList<Integer> i = new ArrayList<>();
		for (int j = 0; j < 10; i.add(++j));
		System.out.println("Original list: " + i);
        
		for(int n : i) { 
			if (n%2 == 0)
				se += n;
			else
				so += n;
		}
		System.out.println("even sum: " + se);
		System.out.println("odd sum: " + so);
		
		i.removeIf(n->prime(n));
		
		System.out.println("List without prime: " + i);
		
	}
	
	private static boolean prime(int n) {
		int i;
		for(i = 2; i <= Math.sqrt(n); i++)
		   if (n%i == 0)
			   return false;
		return true;
	}
}
