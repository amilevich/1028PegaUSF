package com.example.cars;

public class MyCars {

	private String make,model;
	private int year;
	private float serial;
	
	
	public MyCars() {
	
	}


	public String getMake() {
		return make;
	}


	public void setMake(String make) {
		this.make = make;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public float getSerial() {
		return serial;
	}


	public void setSerial(float serial) {
		this.serial = serial;
	}


	@Override
	public String toString() {
		return "MyCars [make=" + make + ", model=" + model + ", year=" + year + ", serial=" + serial + "]";
	}


	public MyCars(String make, String model, int year, float serial) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.serial = serial;
	}
	
	
	
}
