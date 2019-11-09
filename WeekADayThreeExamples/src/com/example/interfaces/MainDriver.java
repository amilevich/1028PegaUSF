package com.example.interfaces;

public class MainDriver {
	
	public static void main(String[]args) {
		
		Developer dev = new Developer();
		dev.walk();
		
		System.out.println(Person.a);
		int b = Person.b;
		System.out.println(Person.b);
	}

}
