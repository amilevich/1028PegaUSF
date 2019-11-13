package com.example.llama;

public class Llama {

	//POJO - Plain Old Java Object
	// models
	
	
	/*
	 * Access modifiers?
	 * restrict access to classes, methods, variables, etc
	 * 
	 * Encapsulation is typically achieved by making variables
	 * private so they can only be accessed within the same class
	 * 
	 * "private" - class itself
	 * default - class itself, package
	 * "protected" - class itself, package, children
	 * "public" - everything
	 * 
	 * It is possible to access private fields by providing
	 * getter and setter methods. Usually public
	 * Get -> returns the var value
	 * Set -> sets value
	 */
	private String name;
	private int height;
	private float weight;
	
	public String getName(String name) {
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	
	
}
