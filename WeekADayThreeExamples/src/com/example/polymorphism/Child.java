package com.example.polymorphism;

public class Child extends Parent{

	//override the talk() method of Parent
	@Override
	public void talk() {
		System.out.println("child is talking");
	}
	
}
