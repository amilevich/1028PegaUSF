package com.example.abstractclass;

public class SuperHero extends Person{

	
	public SuperHero() {
		System.out.println("**In SuperHero constructor**");
	}
	@Override
	public void eat() {
		System.out.println("eating pizza");
		
	}
	
	public void fly() {
		System.out.println("Is that Superman?");
	}
	
}
