package com.example.abstractclass;

public class SuperHero extends Person {

	
	public SuperHero() {
		System.out.println("In super hero constructor");
	}
	@Override
	public void eat() {
		System.out.println("Delicious!");
	}

	public void fly() {
		System.out.println("Here I go flying around!");
	}
}
