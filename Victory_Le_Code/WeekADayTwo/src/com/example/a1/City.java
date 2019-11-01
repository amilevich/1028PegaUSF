package com.example.a1;

public class City {

	private int population;
	private String name;
	private boolean lit;

	public void nameOfCity(String s) {
		System.out.println(getName());
	}

	public void pizzaJoints(String s, int... a) {

		for (int i = 0; i < a.length; i++) {
			System.out.println("Best Pizza in the World at " + s);
			System.out.println("Price of Pizza: " + a[i]);
		}

	}

	// toString()

	public City(int population, String name, boolean lit) {
		super();
		this.population = population;
		this.name = name;
		this.lit = lit;
	}

	@Override
	public String toString() {
		return "City [Population = " + population + ", Name = " + name + ", Lit? = " + lit + ".]";
	}

	// Getter and Setter
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

	public boolean isLit() {
		return lit;
	}

	public void setLit(boolean lit) {
		this.lit = lit;
	}

}
