package com.example.interfaces;

public class Developer implements Person, Animal{

	@Override
	public void walk() {
		
		System.out.println("ayy I'm walking here");
		
	}
		/* 
		 * keyword "implements" from interface -> class
		 * keyword "extends" from interface -> interface 
		 */

	@Override
	public void think() {
		// TODO Auto-generated method stub
		Animal.super.think();
	}





}
