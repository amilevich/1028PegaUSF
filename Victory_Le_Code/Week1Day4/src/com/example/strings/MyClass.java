package com.example.strings;

public class MyClass {

	public static void main(String[] args) {

		String stringOne = "BirdPerson";
		String stringTwo = new String("BirdPerson");
		String stringThree = "BirdPerson";
		
		if(stringOne.equals(stringThree)) {
			System.out.println("Objects are equal");
		}
		
		String sOne="Tammy";
		String sTwo= sOne.concat("and Timmy");
		System.out.println(sOne);
		System.out.println(sTwo);
		
		/*
		 * StringBuilder - mutable
		 * StringBuffer - mutable, thread-safe/synchronized
		 */
//		String Builder
		String sTen = "Rick";
		StringBuilder sBuilderOne = new StringBuilder(sTen);
		sBuilderOne.append(" and Morty");
		System.out.println(sBuilderOne);
		System.out.println(sTen);
		
//		String Buffer
		String sEleven = "Morty";
		StringBuffer sBufferOne = new StringBuffer(sEleven);
		sBufferOne.append(" and Summer");
		System.out.println(sBufferOne);
		sEleven = "Winter";
		System.out.println(sEleven);
		System.out.println(sBufferOne);
	}

}
