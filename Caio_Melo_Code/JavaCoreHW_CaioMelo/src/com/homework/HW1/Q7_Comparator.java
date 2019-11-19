package com.homework.HW1;

//Q7 - Sort employees based on their name, department, and age using Comparator interface.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Q7_Comparator{

	Integer departmentID;
	String name;
	Integer age;

	public Q7_Comparator() {

	}

	public Q7_Comparator(int x, String y, int z) {

		this.departmentID = x;
		this.name = y;
		this.age = z;

	}

	public String toString() {
		return this.departmentID + " " + this.name + " " + this.age;
	}
	
	public static void main(String[] args) {

		ArrayList<Q7_Comparator> ar = new ArrayList<Q7_Comparator>();

		ar.add(new Q7_Comparator(111, "Bubbly", 23)); //Populate Array
		ar.add(new Q7_Comparator(112, "Apply", 21));
		ar.add(new Q7_Comparator(113, "Cootie", 24));

		Collections.sort(ar, new sortById()); //Call ID compare class
		System.out.println("Sorting by departmentID..."); 
		for (int i = 0; i < ar.size(); i++)
			System.out.println(ar.get(i));
		System.out.println();
		
		
		Collections.sort(ar, new sortByName());
		System.out.println("Sorting by name...");
		for (int i = 0; i < ar.size(); i++)
			System.out.println(ar.get(i));
		System.out.println();

		Collections.sort(ar, new sortByAge());
		System.out.println("Sorting by age...");
		for (int i = 0; i < ar.size(); i++)
			System.out.println(ar.get(i));
		System.out.println();

	
}
}

	class sortByName implements Comparator<Q7_Comparator> { //implement Comparator, makes it able to be compared using the order we define.
		public int compare(Q7_Comparator o1, Q7_Comparator o2) { 
			return o1.name.compareTo(o2.name);
		}
	}

	class sortById implements Comparator<Q7_Comparator>{
		public int compare(Q7_Comparator o1, Q7_Comparator o2) {

			return o1.departmentID.compareTo(o2.departmentID);
		}
	}

	class sortByAge implements Comparator<Q7_Comparator> {
		public int compare(Q7_Comparator o1, Q7_Comparator o2) {

			return o1.age.compareTo(o2.age);
		}
	
	}


