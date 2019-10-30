package com.example.polymorphism;

public class Sum {
	
	public int sum(int x, int  y) {
		System.out.println("im inside the sum with two parameters");
		return (x+y);
	}
	
	public int sum(int x, int y, int z, int a) {
		System.out.println("im inside the sum with 4 parameters");
		return (x+y+z+a);
	}
	public double sum(double b, double c) {
		System.out.println("im inside the sum with two arguments of data type double");
		return(b+c);
	}
	public int sum(int ...a) {
		System.out.println("im inside the sum method with var args");
		int sum = 0;
		for(int i=0; i<a.length;i++) {
			sum+=a[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		
		Sum s = new Sum();
		System.out.println(s.sum(4, 5));//java is calling the method satisfying the arguments
		System.out.println(s.sum(4,5,6));//this one will be calling the int...a method
		
		int a = 5;
		int b = 9;
		System.out.println(s.sum(a, b));
		
		int c = 7;
		int d = 47;
		
		System.out.println(s.sum(a, b,c,d));
		
		double e = 2.4;
		double f = 2.14;
		
		System.out.println(s.sum(e, f));
	}
	
}
