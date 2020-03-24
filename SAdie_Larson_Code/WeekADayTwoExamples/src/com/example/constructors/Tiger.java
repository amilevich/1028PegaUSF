package com.example.constructors;

public class Tiger {

	boolean hasEye;
	int stripes;
	int numberOfLegs;
	String name;

	Tiger() {
		System.out.println("in a no arg constructor");
	}

	public Tiger(String name, int numberOfLegs) { // parameterized constructor with two parameters

		super(); // refers to the parent's class constructor
		this.name = name; // "this" is a reference variable that refers to the current object
		this.numberOfLegs = numberOfLegs;
		System.out.println("in a constructor with two parameters");
	}

	public Tiger(boolean hasEye, int stripes, int numberOfLegs, String name) {
		super();
		this.hasEye = hasEye;
		this.stripes = stripes;
		this.numberOfLegs = numberOfLegs;
		this.name = name;
		System.out.println("in a constructor with four parameters");
	}

	public boolean isHasEye() {
		return hasEye;
	}

	public void setHasEye(boolean hasEye) {
		this.hasEye = hasEye;
	}

	public int getStripes() {
		return stripes;
	}

	public void setStripes(int stripes) {
		this.stripes = stripes;
	}

	public int getNumberOfLegs() {
		return numberOfLegs;
	}

	public void setNumberOfLegs(int numberOfLegs) {
		this.numberOfLegs = numberOfLegs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override //implementation of polymorphism - taking same name of parameters as parent class and changing what is
	//in between curly brackets
	
	public String toString() {

		String info = "Does tiger have an eye: " + hasEye + " and the name is " + name + " and the number of legs is "
				+ numberOfLegs + " and the number of stripes is " + stripes;

		return info;
	}
	
	public void info() {
		System.out.println("Tiger's name is " + name + ". It has " + numberOfLegs + " legs.");
	}

}
