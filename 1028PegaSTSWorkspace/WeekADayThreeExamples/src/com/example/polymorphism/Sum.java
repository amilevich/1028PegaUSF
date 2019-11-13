package com.example.polymorphism;

import java.net.StandardSocketOptions;

public class Sum {
	public int sum(int x, int y) {
		System.out.println("Sum of two ints.");
		return(x+y);
	}
	
	public int sum (int x, int y, int z, int a) {
		return(x+y+z+a);
	}
	
	public double sum(double b, double c) {
		return(b+c);
	}
	
	public static void main(String s) {
		System.out.println("Hi, " + s);
	}
	
	public static void main(int i, String s) {
		System.out.println("Booyah");
	}
	
	public int sum(int ...a) { //vararg
		System.out.println("in int var args");
		int sum =0;
		for(int i=0; i<a.length; i++) {
			sum += a[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		
		main("Ben");
		main(1, "Hi");
		
		Sum s = new Sum();
		System.out.println(s.sum(4, 5));
		
		int a = 5;
		int b = 9;
		
		s.sum(a, b);
		
		int c = 7;
		int d = 47;
		
		System.out.println(s.sum(a, b, c, d));
		
		double e = 2.4;
		double f = 2.14;
		System.out.println(s.sum(e, f));
		
		
	}
}
