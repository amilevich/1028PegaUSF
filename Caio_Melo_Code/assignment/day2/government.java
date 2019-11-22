package com.assignment.day2;

public class government {

	String name;
	String size;
	int population;
	
	
	government(){
		
	}
	
	public government(String x, String y, int z) {
		
		this.name = x;
		this.size = y;
		this.population = z;
		
		System.out.println("New country created! Welcome " + this.name + "!");
		
	}
	
	public void declareWar(government ...a) {
		System.out.print(this.name + " declares war on....");
		for(government x : a) {
			System.out.print(x.getName() + ", ");	
		}
		
	}
	
	public void condemn(government x) {
		System.out.println(this.name + "condemns " + x.getName());
	}
	
	public static void aliens() {
		System.out.println("Alien contact has been established - new world order. Hue-Hue.");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}
	
}
