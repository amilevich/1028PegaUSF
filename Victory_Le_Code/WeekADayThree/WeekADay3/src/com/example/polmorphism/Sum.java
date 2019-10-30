package com.example.polmorphism;

public class Sum {
	
	
//	Example of Overloading
	public int sum(int x, int y) {
		return (x+y);
	}
	
	
	public int sum(int x, int y, int z, int a) {
		return (x+y+z+a);
	}
		
	public double sum(double b, double c) {
		return (b+c);
	}
	
	//only work for any int but not different data type
	public int sum(int ...a) {
		int sum = 0;
		for (int i = 0; i<a.length; i++) {
			sum += a[i];
		}
		return sum;
	}
	
	// we can overload the main method 
	public static void main(String s) {
		System.out.println("Hi, " + s);
	}
	
	// overloading main method 
	public static void main(int i, String s) {
		System.out.println("Booyah");
	}
	
//	Main Method
	public static void main(String[] args) {
		
		//overloading main method
		main("Ben");
		main(1,"Hi");
		
		Sum s = new Sum();
		System.out.println(s.sum(4, 5));
		
		int a = 5;
		int b = 9;
		System.out.println(s.sum(a, b));
		
		int c = 7;
		int d = 47;
		System.out.println(s.sum(a, b, c, d));
		
		
		double e = 2.4;
		double f = 2.14;
		System.out.println(s.sum(e, f));
		
		
	}
}
