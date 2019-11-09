package com.example.homework;

public class Developer implements Animal, Person1{
	
	
	public static void  main(String[]args) {
		
		Developer dev = new Developer();
		dev.walk();
	}

	@Override
	public void walk() {
		Animal.super.walk();
		Person1.super.walk();
	}

}
