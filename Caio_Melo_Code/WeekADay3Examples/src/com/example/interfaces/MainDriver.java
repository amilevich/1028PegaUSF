package com.example.interfaces;

public class MainDriver {

	public static void main(String[] args) {
		
		Developer dev = new Developer();
		dev.walk();
		dev.think();
		
		int a = Person.a; //Use Parent class/Interface name to access a static variable in a static way
		
	}
	
}
