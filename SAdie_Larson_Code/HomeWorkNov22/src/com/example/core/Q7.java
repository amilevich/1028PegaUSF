package com.example.core;
//TO DO
/*
 * Sort two employees based on their name, 
 * department, and age using the Comparator interface
 */
import java.util.Comparator;

public class ComparatorQ7 implements Comparator {

	public String name;
	public String department;
	public int age;

	public static void main(String[] args) {

		ComparatorQ7 e1 = new ComparatorQ7();
		ComparatorQ7 e2 = new ComparatorQ7();
		e1.name = "Bill";
		e1.age = 71;
		e1.department = "Sales";
		
		e2.name = "Avery";
		e2.age = 21;
		e1.department = "HR";
		
	}

	@Override
	public int compare(Object arg0, Object arg1) {
		return 0;
	}

}
