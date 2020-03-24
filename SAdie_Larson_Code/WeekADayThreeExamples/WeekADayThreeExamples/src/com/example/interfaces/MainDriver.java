package com.example.interfaces;

public class MainDriver {
	public static void main(String[] args) {

		Developer dev = new Developer();
		dev.walk();
		dev.think();
		dev.sound();

		int j = dev.a; // would work but gives a warning
		System.out.println(j);

		System.out.println(Person.a); // this does not give warnings - BETTER

		// Person me = new Person(); //cannot be instantiated since interface
	}
}
