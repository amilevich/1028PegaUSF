package com.example.strings;

public class MyClass {

	public static void main(String[] args) {
		
//		String s1 = "BirdPerson";
//		String s2 = new String("BirdPerson");
//		String s3 = "BirdPerson";
//		
//		if(s1 == s2) {
//			System.out.println("Objects are equal - using =="); //would not enter since looks at memory of object
//		}
//		if(s1 == s3) {
//			System.out.println("Objects are equal - using == for non new String"); //would print since no new keyword o will look at stirng literla address
//		}
//		
//		if(s1.equals(s2)){
//			System.out.println("Objects are equal - using equals ");
//		}
//		
//		if(s1.equals(s3)){
//			System.out.println("Objects are equal - using equals ");
//		}

		
		//**************************************************//
		
		String sOne = "Tammy";
//		String sTwo = sOne.concat(" and Timmy");
//		System.out.println(sOne); //will print Tammy
//		System.out.println(sTwo); //will print Tammy and Timmy
	
//		sOne.concat(" and Timmy");
//		System.out.println(sOne); //will just print Tammy since not assigning anything to point to string literal
		
//		System.out.println(sOne.concat(" and Timmy")); //will print both since printing the string literal right then
		
		
		/*
		 * StringBuilder - mutable
		 * StringBuffer - mutable, threadsafe/synchronized
		 */
		String s10 = "Rick";
		StringBuilder sBuilderOne = new StringBuilder(s10);
		sBuilderOne.append(" and Morty");
		System.out.println(sBuilderOne);
		System.out.println(s10);
		
		String s11 = "Morty";
		StringBuffer sBufferOne = new StringBuffer(s11);
		sBufferOne.append(" and Summer");
		System.out.println(sBufferOne);
		System.out.println(s11);
		System.out.println();
		s11 = "Winter";
		System.out.println(sBufferOne); //will still be Morty and Summer because appended before s11 was changed 
		
	}
}
