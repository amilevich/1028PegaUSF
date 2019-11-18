package com.projects.corejavahomework;

import java.util.Comparator;

public class Employee implements Comparator<Employee> {
	// Q7 class, Sort two employees based on their name, department, and age using
	// the Comparator interface.
	private String name, department;
	private int age;

	public Employee() {
		
	}
	public Employee(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}

	@Override
	public int compare(Employee o1, Employee o2) {
		int score = 0;
		score += compareName(o1.getName(), o2.getName());
		score += compareDepartment(o1.getDepartment(), o2.getDepartment());
		score += compareAge(o1.getAge(), o2.getAge());
		return score;
	}

	public int compareName(String o1, String o2) {
		return o1.compareTo(o2) * 2;
	}

	public int compareDepartment(String o1, String o2) {
		return o1.compareTo(o2) * 3;
	}

	public int compareAge(int o1, int o2) {
		if (o1 == o2) {
			return 0;
		} else if (o1 < o2) {
			return 1;
		} else if (o1 > o2) {
			return -1;
		}
		return 0;
	}

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return name + " " + age + " " + " " + department;
	}
}
