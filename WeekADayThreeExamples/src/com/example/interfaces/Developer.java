package com.example.interfaces;

public class Developer implements Person {

	@Override
	public void walk() {
		System.out.println("ayy I'm walking here!");
	}
	
	/*
	 * if you are inheriting an interface from a class
	 * the keyword is "implements"
	 * if you are inheriting an interface from an interface
	 * the keyword is "extends"
	 * if you are inheriting a class from a class
	 * the keyword is "extends"
	 */

}
