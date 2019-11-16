package com.example.serialization;

import java.io.Serializable;

public class Car implements Serializable{

	/*
	 * SerialVersionUID
	 * represents your class's version
	 * 
	 * The serialization runtime associates a version number with each Serializable class. 
	 * It is used during deserialization to verify that the sender and the receiver of the serialized object have loaded the correct class.
	 * 
	 * If we have a different UID for sender/receiver, we get an InvalidClassException
	 */
	
	/**
	 * JavaDocs
	 * @author Victory Le
	 * @param into my methods
	 */
	
	private static final long serialVersionUID = -7055778693587183800L;
	private boolean hasWheels;
	private String wheelShape;
	private transient int doors; // transient keyword 
	private String model;
	// transient keyword hides data in the process of deserialization. 
	//it prints out the default value for that data type instead of the actual value
	public Car() {
		
	}

	
	public Car(boolean hasWheels, String wheelShape, int doors, String model) {
		super();
		this.hasWheels = hasWheels;
		this.wheelShape = wheelShape;
		this.doors = doors;
		this.model = model;
	}


	@Override
	public String toString() {
		return "Car [hasWheels=" + hasWheels + ", wheelShape=" + wheelShape + ", doors=" + doors + ", model=" + model
				+ "]";
	}


	public boolean isHasWheels() {
		return hasWheels;
	}

	public void setHasWheels(boolean hasWheels) {
		this.hasWheels = hasWheels;
	}

	public String getWheelShape() {
		return wheelShape;
	}

	public void setWheelShape(String wheelShape) {
		this.wheelShape = wheelShape;
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
