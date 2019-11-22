package com.examples.corehomework;

import java.util.ArrayList;
import java.util.Collections;

public class Q07Main

{

	public static void main(String[] args) {

		ArrayList<Q07Comparator> empList = new ArrayList<Q07Comparator>();

		empList.add(new Q07Comparator("Felix", "Programming", 25));

		empList.add(new Q07Comparator("John", "HR", 22));

		System.out.println("List before Sorting");

		for (int emp = 0; emp < empList.size(); emp++)

		{

			System.out.println(empList.get(emp));

		}

		System.out.println("\n*********************");

		System.out.println("Sorted list by name: ");

		Collections.sort(empList, new SortByName());

		for (int i = 0; i < empList.size(); i++)

		{

			System.out.println(empList.get(i));

		}

		System.out.println("***************************");

		System.out.println("\nSorted list by department: ");

		Collections.sort(empList, new SortByDepartment());

		for (int i = 0; i < empList.size(); i++)

		{

			System.out.println(empList.get(i));
		}
		
		System.out.println("\n********************");

		System.out.println("Sorted list by age: ");

		Collections.sort(empList, new SortByAge());

		for (int i = 0; i < empList.size(); i++)

		{

			System.out.println(empList.get(i));
		}
	}
}