package com.assignment2.interfaces;

public class Developer implements Person, Animal{

	@Override
	public void sleep() {
		
		Animal.super.sleep();
		
	}
	
	public static void main(String[] args) {
		Developer d = new Developer();
		d.sleep();
	}
	
}
