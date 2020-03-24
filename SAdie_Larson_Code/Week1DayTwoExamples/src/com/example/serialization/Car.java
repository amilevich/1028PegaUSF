package com.example.serialization;

import java.io.Serializable;

public class Car implements Serializable {

	 /*
	 * SerialVersionUID represents your class's version
	 * 
	 * The serialization runtime associates a version number with each Serializeable
	 * class. It is use during deserialization to verify that the sender and the
	 * receiver of the serialized object have loaded the correct class
	 * 
	 * If we get a different UID for sender/receiver, we get
	 * an InvalidClassExcetpion
	 */
	
	/**
	 * javadocs 
	 * @author Sadie Larson
	 * @param into my methods
	 */
	
	private static final long serialVersionUID = -7055778693587183800L;
	private boolean hasWheels;
	private transient String wheelShape;
	private transient int doors; 
	//transient - hides data in the process of de serialization
	//prints out the defualt value for the data type 
	//instead of the actual value
	private String model;
	
	public Car() { //when using serilizeable make sure not to include a no args constructor
		super();
	}

	public Car(boolean hasWheels, String wheelShape, int doors, String model) {
		super();
		this.hasWheels = hasWheels;
		this.wheelShape = wheelShape;
		this.doors = doors;
		this.model = model;
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

	@Override
	public String toString() {
		return "Car [hasWheels=" + hasWheels + ", wheelShape=" + wheelShape + ", doors=" + doors + ", model=" + model
				+ "]";
	}

	
}
