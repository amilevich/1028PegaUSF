package com.example.abstractclass;

public class SuperHero extends Person {

	public SuperHero() {
		super();//implicit applied to go to parent constructor
		System.out.println("******in SuperHero Constructor********");
	}
	@Override
	public void eat() {
		System.out.println("Pizza Pizza Pizza");
	}
	
	public void fly() {
		System.out.println("is it an airplane? is it a bird?");
	}
	
	public int name(int a, int b) {
		int sum= 0;
		sum+=a;
		sum+=b;
		return sum;

	}

}
