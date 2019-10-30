package com.example.interfaces;

public class Developer implements Person, Animal {

	@Override
	public void walk() {
		System.out.println("Hey I'm walking here!");
	}

	@Override
	public void think() {
		// TODO Auto-generated method stub
		Person.super.think();
	}

	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("Roar");
	}

	/*
	 * if you are inheriting an interface from a class the keyword is "implements" 
	 * 
	 * if you are inheriting an interface from an interface
	 * then the keyword is "extends"
	 * 
	 * if you are inheriting a class from a class, the keyword
	 * is "extends"
	 * 
	 * you cannot inherit a class from an interface 
	 */
}
