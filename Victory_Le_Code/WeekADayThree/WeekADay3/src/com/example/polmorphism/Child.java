package com.example.polmorphism;

public class Child extends Parent{
	
	//Override the talk() method of Parent
	@Override
	public void talk() {
		System.out.println("Child is talking ");
	}

}