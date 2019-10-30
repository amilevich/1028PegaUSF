package com.example.interfaces;

public class Developer implements Person, Animal{


	/*
	 * if you are inheriting an interface from a class the keyword is "implements"
	 * if you are inheriting an interface from an interface the keywords is "extends"
	 * if you are inheriting a class from a class the keyword is "extends"
	 */
	
	@Override
	public void walk() {
		System.out.println("heyyy I'm walking here!");
	}

	@Override
	public void think() {
		Person.super.think();
		//Animal.super.think();
		
	}
	
}
