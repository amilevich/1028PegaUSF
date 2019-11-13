package com.example.interfaces;

public class MainDriver {
	
	public static void main(String[] stuffs) {
		
		Developer dev = new Developer();
		dev.walk();
		
		System.out.println(Person.a); //(interface name.name of var
		int b = Person.b;
		System.out.println(b);
	}
	
}
