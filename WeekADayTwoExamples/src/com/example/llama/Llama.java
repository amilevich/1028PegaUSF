package com.example.llama;

public class Llama {
	
	//POJO - Plain Old Java Object (only have the variables)
	//models
	/*
	 * access modifiers restrict access to classes, methods, variables, etc
	 * 
	 * Encapsulation is typically  achieved by making variables
	 * private so they can only be accessed within the same class
	 * 
	 * "private" access only inside the classes
	 * "default" access to classes and packages
	 * "protected" access to classes, packages and children
	 * "public" access to classes, packages, children and everything
	 * 
	 * However, it is possible to access the private fields if we provide getter and setter methods. Usually, they are public.
	 * Get will return the variable
	 * Set will sets the value
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
