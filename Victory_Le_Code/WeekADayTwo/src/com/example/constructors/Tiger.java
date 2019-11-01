package com.example.constructors;

public class Tiger {

	boolean hasEye;
	int stripes;
	int numberOfLegs;
	String name;

	public Tiger(boolean hasEye, int stripes, int numberOfLegs, String name) {
		super();
		this.hasEye = hasEye;
		this.stripes = stripes;
		this.numberOfLegs = numberOfLegs;
		this.name = name;
	}

	Tiger() {
		System.out.println("in a no arg constructor");
	}

	public Tiger(String name, int numberOfLegs) {
		super(); // refers to the parent class contructors
		this.name = name;
		// reference variable that refers to the current object
		this.numberOfLegs = numberOfLegs;
		this.name = name;
		System.out.println("in a consturctor with four parameter");
	}
}
