package com.example.believe;

public class Vehicle {
	
	
		 String color;
		 String name;
		 double weight;
		
		 public Vehicle (String name) {
			 super();
			 this.name = name;
			
		 }
		
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getWeight() {
			return weight;
		}
		public void setWeight(double weight) {
			this.weight = weight;
		}
		
		
	public static int getRandomColor(int max) {
		return(int) (Math.random()*max);
	}
		
	public String getColor(String ...color) {
		int randomColor = getRandomColor(3);
		return color [randomColor];
	}
	
	public String toString() {
		String info = "The name of the car is " +name+ " and the color is " +getColor ("Red", "Blue"
				, "grey", "black");
		return info;
	}

}
