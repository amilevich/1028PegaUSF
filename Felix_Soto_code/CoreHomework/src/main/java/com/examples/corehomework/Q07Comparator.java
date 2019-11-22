package com.examples.corehomework;

import java.util.Comparator;

public class Q07Comparator

{
	String name;
	String department;
	int age;
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
	@Override
	public String toString() {
		return "Q7Comparator [name=" + name + ", department=" + department + ", age=" + age + "]";
	}
	public Q07Comparator(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}
}

class SortByName implements Comparator<Q07Comparator>

{

	public int compare(Q07Comparator first, Q07Comparator second)

	{

		return first.name.compareTo(second.name);

	}

}

class SortByAge implements Comparator<Q07Comparator>

{

	public int compare(Q07Comparator first, Q07Comparator second)

	{

		return first.age - second.age;

	}

}

class SortByDepartment implements Comparator<Q07Comparator>

{

	public int compare(Q07Comparator first, Q07Comparator second)

	{

		return first.department.compareTo(second.department);

	}
}