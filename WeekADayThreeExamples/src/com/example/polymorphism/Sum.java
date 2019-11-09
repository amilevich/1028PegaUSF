package com.example.polymorphism;

public class Sum {
	
	public int sum(int x, int y) {
		System.out.println("sum with two ints");
		
		return (x + y);	
	}
	
	public int sum(int x, int y, int z, int a) {
		return (x + y + z + a);
	}
	//overloading
	public double sum(double b, double c) {
		return(b + c);
	}
	
	public int sum(int ...a) {
		System.out.println("sum with varargs");
		int sum = 0;
		for(int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}
	//overloading the main method
	public static void main(String s) {
		System.out.println("Hi " + s);
	}
	
	
	
	public static void main(String[] args) {
		
		main("Ben");// calling the main method
		
		Sum s = new Sum();
		System.out.println(s.sum(4,5));
		
		int a = 5;
		int b = 8;
		System.out.println(s.sum(a, b));
		
		int c = 7;
		int d = 47;
		System.out.println(s.sum(a, b, c, d));
		
		
		double e = 20.4;
		double f = 2.5;
		System.out.println(s.sum(e, f));
		
	}

}
