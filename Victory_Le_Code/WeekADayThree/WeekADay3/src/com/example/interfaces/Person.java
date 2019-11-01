package com.example.interfaces;

public interface Person {

		public static final int b = 8;
		
		int a = 4;
		//implicitly always public static final
		
		
		public abstract void walk();
		
		default public void think() {
			System.out.println("concrete method with Java 8...Thinking");
		}
}
