package com.example.HelloWorld;

public class MyFirstClass {

	
	
	public static void main(String[] args) {
		
		System.out.println("Hey, guyz!");
		System.out.println("Hey, Gurls");
		
		Zebra jeff = new Zebra();
		
		
		Zebra.eat();
		jeff.walk();
		
		System.out.println("Zebra number 2 has " + jeff.numOfSpots + " spots");
		System.out.println("Zebra's name is " + jeff.name);
				
	}
}
