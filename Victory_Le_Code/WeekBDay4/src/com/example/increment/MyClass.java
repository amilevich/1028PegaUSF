package com.example.increment;

public class MyClass {

	public static void main(String[] args) {
		
		int i = 300;
//		System.out.println(i + i + "Blue"); //600Blue
//		System.out.println("Red" + i + i);// Red300300
//		//order of operation matters. From left to right!
//		//if you see another string to another string 
//		System.out.println("Red" + i + i/2);//red300150
//		System.out.println("Green" + (i+i));//green600
		
		int num = 50;
		System.out.println(++num); // pre increment  
		System.out.println("num is currently " + num);
		System.out.println(num++); // post increment  
		System.out.println("num is currently " + num);  
		System.out.println(--num);
		System.out.println("num is currently " + num);  
		System.out.println(num--); 
		System.out.println("num is currently " + num);   



	}

}
