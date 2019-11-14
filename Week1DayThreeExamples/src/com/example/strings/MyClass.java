package com.example.strings;

public class MyClass {

	public static void main(String[] args) {

		String stringOne = "BirdPerson";
		String stringTwo = new String("BirdPerson");
		String stringThree = "BirdPerson";
		
		if(stringOne == stringTwo) {
			//System.out.println("objects are equal");
		}
		
		String sOne = "Tammy"; //sOne object in the heap pointing to a 
		//String literal "Tammy" in the String Pool
		sOne = sOne.concat(" and Timmy"); //string literal "Tammy and Timmy"
	//	System.out.println(sOne);
		//System.out.println(sTwo);
		
		/*
		 * StringBuilder - mutable
		 * StringBuffer - mutable, thread-safe/synchronized
		 */
		String sTen = "Rick";
		StringBuilder sBuilderOne = new StringBuilder(sTen);
		sBuilderOne.append(" and Morty");
		//System.out.println(sBuilderOne);
		//System.out.println(sTen);
		
		String sEleven = "Morty";
		StringBuffer sBufferOne = new StringBuffer(sEleven);
		sBufferOne.append(" and Summer");
		System.out.println(sBufferOne);
		sEleven = "Winter";
		System.out.println(sEleven);
		System.out.println(sBufferOne);
		
	}

}
