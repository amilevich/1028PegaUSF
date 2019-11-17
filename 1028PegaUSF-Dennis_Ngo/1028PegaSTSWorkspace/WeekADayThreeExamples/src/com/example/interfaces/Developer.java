package com.example.interfaces;

public class Developer implements Person{

	@Override
	public void walk() {
		System.out.println("Ayy I'm walking here!");
		
	}
	
	/*
	 * if you are inheriting an interface from class keyword is "implements"
	 * if you are inheriting an interface from an interface keyword is "extends"
	 * if you are inheriting a class from class keyword is "extends"
	 */
}
