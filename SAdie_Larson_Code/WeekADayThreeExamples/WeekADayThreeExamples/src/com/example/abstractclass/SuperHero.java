package com.example.abstractclass;

public class SuperHero extends Person {

	@Override
	public void eat() {
		System.out.println("nom nom nom");
	}

	public void fly() {
		System.out.println("whoosh");
	}

	public SuperHero() {
		System.out.println("In Superhero constructor");
	}

}
