package com.example.increment;

public class MyClass {

	public static void main(String[] args) {

		int i = 300;
		System.out.println(i + i + "Blue"); //600 blue
		//when int operations first then string will do math then string
		System.out.println("Red" + i + i); // Red300300
		//when red + i will convert to string and then another 
		
		System.out.println(i + i/2); // Red300150
		System.out.println("Green" + (i + i)); // Red600
		
		
		int num = 50;
		System.out.println(++num); //pre increment, adding first then printing 51
		System.out.println("num is currently " + num);
		System.out.println(num++); //post increment, printing first then adding 51
		System.out.println("num is currently " + num); //52
		System.out.println(--num); //pre decrement 51
		System.out.println("num is currently " + num); //51
		System.out.println(num--); //51
		System.out.println("num is currently " + num); //50
		
			
	}

}
