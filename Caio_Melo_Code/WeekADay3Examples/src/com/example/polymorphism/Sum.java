package com.example.polymorphism;

public class Sum {
	
	public int sum(int x, int y) {
		
		return(x+y);
	}
	
	public int sum(int ...a) {
		int sum1 = 0;
		for(int i = 0;i<a.length;i++) {
			sum1+=a[i];
		}
		return sum1;
	}
	

	public static void main(String[] args) {
		
		Sum s = new Sum();
		s.sum(4, 5);
		System.out.println(s.sum(1,2,3,4,5,6,7,8,9,10));
	}
}
