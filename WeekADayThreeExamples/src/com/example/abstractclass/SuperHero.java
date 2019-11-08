package com.example.abstractclass;

public class SuperHero extends Person{

	public SuperHero() {
		System.out.println("im in superhero construtor");
	}
	@Override
	public void eat() {
		System.out.println("eating pizza");
		
	}
	
	public void fly() {
		System.out.println("is it a bird, is it a plane, no it is superman!!");
	}
	
	
}
