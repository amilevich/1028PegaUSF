package com.example.homework;

public interface Animal {

	public default void walk() {
		System.out.println("walking like humans");
	}
}
