package com.example.llama;

public class Llama {

	//POJO - Plain Old Java Object (only the variables)
	//models
	
	/*
	 * access modifiers?
	 * restrict access to classes, methods, variables, etc
	 * 
	 * Encapsulation is typically achieved by making variables
	 * private so they can only be accessed within the same class.
	 * 
	 * "private" - class itself
	 * default - class itself, package
	 * "protected" - class itself, package, children
	 * "public" - class itself, package, children, everything
	 * 
	 * However, it is possible to access the private fields if we 
	 * provide getter and setter methods. Usually, they are public.
	 * Get -> returns the variable value
	 * Set -> sets the value
	 */
	
	private String name;
	private int height;
	private float weight;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
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
