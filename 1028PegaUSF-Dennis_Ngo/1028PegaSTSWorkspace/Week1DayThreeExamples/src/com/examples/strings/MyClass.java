package com.examples.strings;

public class MyClass {

	public static void main(String[] args) {
		
		String stringOne = "BirdPerson";
		String stringTwo = new String ("BirdPerson");
		String stringThree = "BirdPerson";
		
		if(stringOne == stringTwo) {//compare mem. location
			System.out.println("objects are equal");
		}
		String sOne = "Tammy";//sOne obj in heap pointing to a String Literal "Tammy" in string pool
		String sTwo = sOne.concat(" and Timmy"); //append string to prev. string, string literal "Tammy, and Timmy"
		//System.out.println(sOne);
		//System.out.println(sTwo);

		
		/*
		 * StringBuilder - mutable
		 * StringBuffer - mutable, thread-safe / synchronized
		 * 
		 */
		String sTen = "Rick";
		StringBuilder sBuilderOne = new StringBuilder(sTen);
		sBuilderOne.append(" and Morty");
		System.out.println(sBuilderOne);
		System.out.println(sTen);
		
		String sEleven = "Morty";
		StringBuffer sBufferOne = new StringBuffer(sEleven);
		sBufferOne.append(" and Summer");
		System.out.println(sBufferOne);
		sEleven = "Winter";
		System.out.println(sEleven);
		System.out.println(sBufferOne);
	}

}
