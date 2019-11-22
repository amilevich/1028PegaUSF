package com.example.triangle;

public class MyClass {

	public static void main(String[] args) {
		
		String z = "0";
		String o = "1";
		String s = "0";
		System.out.println(s);
		for (int i = 1; i < 5; i++) {
			if (i%2 != 0) {
				s = o + s;
				System.out.println(s);
				s = s + o;
				System.out.println(s);
			}
			else {
				s = z + s;
				System.out.println(s);
				s = s + z;
				System.out.println(s);
			}
				
			
			
		}

	}

}
