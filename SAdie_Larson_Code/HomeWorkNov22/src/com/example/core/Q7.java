package com.example.core;

//TO DO
/*
 * Sort two employees based on their name, 
 * department, and age using the Comparator interface
 */
import java.util.Comparator;

public class Q7 implements Comparator {

	private String name;
	private String department;
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return " [name=" + name + ", department=" + department + ", age=" + age + "]";
	}

	public static void main(String[] args) {

		Q7 e1 = new Q7();
		Q7 e2 = new Q7();
		e1.name = "Bill";
		e1.age = 71;
		e1.department = "Sales";

		e2.name = "Avery";
		e2.age = 21;
		e1.department = "HR";

		System.out.println("Sorted by name: ");
		if (e1.compare(e1.name, e2.name) > 0) {
			System.out.println("1. " + e1.toString());
			System.out.println("2. " + e2.toString());
		} else {
			System.out.println("1. " + e2.toString());
			System.out.println("2. " + e1.toString());
		}

		System.out.println("Sorted by department name: ");
		if (e1.compare(e1.department, e2.department) > 0) {
			System.out.println("1. " + e1.toString());
			System.out.println("2. " + e2.toString());
		} else {
			System.out.println("1. " + e2.toString());
			System.out.println("2. " + e1.toString());
		}

		System.out.println("Sorted by age: ");
		if (e1.compare(e1.age, e2.age) > 0) {
			System.out.println("1. " + e1.toString());
			System.out.println("2. " + e2.toString());
		} else {
			System.out.println("1. " + e2.toString());
			System.out.println("2. " + e1.toString());
		}
	}

	@Override
	public int compare(Object o1, Object o2) {
		/*if (o2 > o1) {
			return 1;
		}*/
		return 0;
	}
}
