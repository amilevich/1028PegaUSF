package com.example.assignmentOne;

public class Model {

	String Name;
	int mph;
	float weight1;
	String color;
	int mileage;
	float weight;
	
	
	
	//Methods and Varargs
	public void runItBackTurbo() {
		System.out.println("VROOM VROOM CATCH ME IF YA CAN VROOOOM");
	}
	
	public void useBreak() {
		System.out.println("Slow down feller");
	}
	
	public void year() {
		
		int carYear[] = {1286,1928,1935,1923};
		
		for(int i = 0; i<carYear.length; i++) {
			System.out.print(carYear[i]+", ");
		};
	}
	
	public static void eat() {
		System.out.println("Spills ketchup");
	}
	
//	Getters and Setters
	public int getMph() {
		return mph;
	}
	public void setMph(int mph) {
		this.mph = mph;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public float getWeight() {
		return weight1;
	}
	public void setWeight(float weight) {
		this.weight1 = weight;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	
	
}
