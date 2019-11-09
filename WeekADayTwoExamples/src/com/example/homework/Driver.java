package com.example.homework;

public class Driver {
	
	public static void main(String[] args) {
		
		
		Passenger pass1= new Passenger ();
		Passenger pass2 = new Passenger();
		Passenger pass3 = new Passenger();
		
		Passenger.staticMethod();
		Passenger.anotherStaticMethod();
		Passenger.money();
		
		//create an array of type Passenger
		//put three Passengers into the array
		//print out the objects in the array with a for loop
		System.out.println("My passengers are: ");
		
		Passenger[] passengers = {pass1, pass2, pass3}; //pass1, pass2, pass3
		//array of type Passenger
		
		for(int p = 0; p < passengers.length; p++) {
			System.out.println(passengers[p]);
	}
	
		
	}

}
