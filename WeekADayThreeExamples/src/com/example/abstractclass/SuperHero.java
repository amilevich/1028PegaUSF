package com.example.abstractclass;

public class SuperHero extends Person {

	@Override
	public void eat() {
		System.out.println("eating pizzza");
		
	}
	
	public SuperHero() {
		System.out.println("in a super hero constructor");
	}
	
	public void fly() {
		System.out.println("is it an airplane? is it a bird?");
	}
	
	

}
