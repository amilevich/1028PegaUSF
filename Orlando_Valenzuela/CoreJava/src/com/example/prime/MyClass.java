package com.example.prime;


import java.util.ArrayList;

public class MyClass {

	public static void main(String[] args) {
		
		ArrayList<Integer> p = new ArrayList<>();
		
		for(int i = 1; i <= 100; p.add(i++));
		
		p.forEach(n->{if(prime(n)) {System.out.println(n);}});

	}
	
	private static boolean prime(int n) {
		int i;
		for(i = 2; i <= Math.sqrt(n); i++)
		   if (n%i == 0)
			   return false;
		return true;
	}

}
