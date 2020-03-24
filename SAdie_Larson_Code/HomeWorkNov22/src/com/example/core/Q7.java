package com.example.core;

//TO DO
/*
 * Sort two employees based on their name, 
 * department, and age using the Comparator interface
 */
import java.util.Comparator;

public class Q7 {

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
		e2.age = 72;
		e2.department = "HR";

		System.out.println("Sorted by name: ");
		if (Q7.nameComp.compare(e1, e2) > 0) {
			System.out.println("1. " + e1.toString());
			System.out.println("2. " + e2.toString());
		} else {
			System.out.println("1. " + e2.toString());
			System.out.println("2. " + e1.toString());
		}

		System.out.println("Sorted by department name: ");
		if (Q7.departmentComp.compare(e1, e2) > 0) {
			System.out.println("1. " + e1.toString());
			System.out.println("2. " + e2.toString());
		} else {
			System.out.println("1. " + e2.toString());
			System.out.println("2. " + e1.toString());
		}

		System.out.println("Sorted by age: ");
		if (Q7.ageComp.compare(e1, e2) > 0) {
			System.out.println("1. " + e1.toString());
			System.out.println("2. " + e2.toString());
		} else {
			System.out.println("1. " + e2.toString());
			System.out.println("2. " + e1.toString());
		}
	}

	public static final Comparator<Q7> nameComp = new Comparator<Q7>() {

		@Override
		public int compare(Q7 arg0, Q7 arg1) {
			return (arg1.name).compareTo(arg0.name);
		}
	};
	public static final Comparator<Q7> departmentComp = new Comparator<Q7>() {

		@Override
		public int compare(Q7 arg0, Q7 arg1) {
			return (arg1.department).compareTo(arg0.department);
		}
	};

	public static final Comparator<Q7> ageComp = new Comparator<Q7>() {

		@Override
		public int compare(Q7 arg0, Q7 arg1) {
			// TODO Auto-generated method stub
			return (arg1.age) - (arg0.age);
		}
	};
}
