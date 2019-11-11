package com.example.inheritance;

public class MainDriver {

	public static void main(String[] args) {
		
		SuperHero superH = new SuperVillian();
		System.out.println(superH.alias);
		
		System.out.println((SuperVillian)superH.alias);
		
		/*
		 * Casting - taking an object on one particular type and turning it into another object type
		 * 
		 * Two types of Casting:
		 * 
		 * Upcasting - casting a subtype(child) to a supertype(parent)
		 * Upcast when you want to write general code that only deals with the supertype 
		 * 
		 * Downcasting - casting to a subtype(child) from a supertype
		 * Downcast is used to access specific behavior of a subtype
		 */
	}

}
