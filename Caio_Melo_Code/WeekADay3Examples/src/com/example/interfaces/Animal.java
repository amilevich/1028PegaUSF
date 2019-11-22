package com.example.interfaces;

public interface Animal {
public void walk();

default public void think() {
	System.out.println("Print from animal interface....");
}
}
