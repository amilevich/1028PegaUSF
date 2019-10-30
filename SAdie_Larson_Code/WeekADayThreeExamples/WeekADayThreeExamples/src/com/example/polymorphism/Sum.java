package com.example.polymorphism;

public class Sum { //all about overloading

	public int sum(int x, int y) {
		return (x + y);
	}
	
	public int sum(int x, int y, int z, int a) {
		return (x+y+z+a);
	}
	
	public double sum(double b, double c) {
		return (b + c);
	}
	
	public int sum(int ...a) {
		int sum = 0;
		for(int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}
	
	public static void main(String s) {
System.out.println("Hi, " + s);
	}
	
	public static void main(int i, String s) {
		System.out.println(i + s);
	}

	
	public static void main(String[] args) {

		main("Ben");
		main(5, "y");
		
		// System.out.println(sum(4,5)); // can only do if sum is static
		
		Sum s = new Sum();
		System.out.println(s.sum(4, 5)); 
		
		int a = 2;
		int b = 4;
		int summed = s.sum(a, b);
		System.out.println(summed); 
		System.out.println(s.sum(a, b));
		
		int c = 10;
		int d = 6;
		
		System.out.println(s.sum(a, b, c, d));
		
		double e = 2.4;
		double f = 2.14;
		System.out.println(s.sum(e, f)); //only works since overloaded with type double
		
	}
}
