package com.homework.algorthim;

import java.util.Comparator;

public class Q7Comparator {
	public String name;
	public String age;
	public String department;
	
	
	
	//Constructor
	public Q7Comparator() {
		
	}
	
	public Q7Comparator(String name, String age, String department) {
		super();
		this.name = name;
		this.age = age;
		this.department = department;
	}

	@Override
	public String toString() {
		return "Q7Comparator [name=" + name + ", age=" + age + ", department=" + department + "]";
	}
}

class sortName implements Comparator<Q7Comparator> {
	
	public int compare(Q7Comparator a, Q7Comparator b) {
		return a.name.compareTo(b.name);
	}
}

class sortAge implements Comparator<Q7Comparator>{
	
	public int compare(Q7Comparator a, Q7Comparator b) {
		return a.age.compareTo(b.age);
	}
}

class sortDepartment implements Comparator<Q7Comparator>{
	
	public int compare (Q7Comparator a, Q7Comparator b) {
		return a.department.compareTo(b.department);
	}
}