package com.example.methodstudy;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class MyClass {
	
	public static void main(String[] args) {

	Parent Dad = new Parent();
	
	Child Son = new Child();
	
	Parent Daughter = new Child();
	
	
	Dad.setName("Thomas");
	Son.setAge(6);
	
	System.out.println(Son.age); //Accessing a protected variable from child class
	System.out.println(Dad.age); //Acessing a protected variable from Parent class.
	
	List<Integer> Groceries = new ArrayList<Integer>();
	
	ListIterator<Integer> it = Groceries.listIterator();
	
	Groceries.add(10);
	Groceries.add(14);
	Groceries.add(12);
	Groceries.add(15);
	Groceries.add(17);
	Groceries.add(19);
	
	
	}
}
