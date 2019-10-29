package com.example.llama;

public class Lllama {

	//POJO - Plain Old Java Object (only has the variables)
	//models
	
	/*
	 * access modifiers
	 * they restrict access to classes, methods, variables, etc
	 * 
	 * Encapsulation is typically achieved by making the variables
	 * private so they can only be acccessed within the same class
	 * 
	 * "private" - class itself
	 * default - class itslef and package 
	 * "protected" - class itslef, package, children
	 * "public" - class itself, package, children, everything
	 * Note: most restricted to least
	 * 
	 * 
	 * However, it is possible to access the private fields if we 
	 * provide getter and setter methods. Usually, they are public.
	 * 
	 * Get -> returns the variable name
	 * Set -> sets the value
	 * 
	 * "this" refers back to this particular object / class
	 * "super" refers to parent of class
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
