package com.example.assignment;

public class States {

	int population;
	String name;
	double percentStudents;
	
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPercentStudents() {
		return percentStudents;
	}
	public void setPercentStudents(double percentStudents) {
		this.percentStudents = percentStudents;
	}
	
	public static void hello() {
		System.out.println("Hello Wrold!");
	}
	
	public String peopleInterested(int ...a) {
		System.out.println("There are " + a.length + " people interested in going to school here.");
		for(int i = 0; i < a.length; i++) {
		System.out.println(" With interest levels form 0-100: " + a[i] );
	}
	return "Yay";
	}
	
	public void temperature() {
		System.out.println("It's all under 30 degrees celsius!");
	}
	
	
	@Override
	public String toString() {
		String info = "The state "  + name + " has a population of " + population + " whose percentage of students = " + percentStudents; 
		return info;
	}
	
	
	
}
