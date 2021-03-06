package com.example.sorting;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainDriver {
	
	/*
	 * Comparable Interface (natural ordering)
	 * ordering provided by the JVM
	 * interface allows to sort based on one element
	 * numbers - ascending
	 * characters - unicode values
	 * 
	 * Comparator Interface (unnatural ordering)
	 * All values can be compared to all other values
	 * Custom ordering
	 *
	 */

	public static void main(String[] args) {
		List<Student> students  = new ArrayList<Student>();
		students.add(new Student(7, "Timmy", 1.2, "4th grade", LocalDate.of(1996, 6, 26)));
		students.add(new Student(6, "Tommy", 3.7, "7th grade", LocalDate.of(2002, 2, 21)));
		students.add(new Student(1, "Chris", 4.0, "10th grade", LocalDate.of(2007, 1, 24)));
		students.add(new Student(42, "Kefnet", -1, "3.2 grade...", LocalDate.of(1995, 10, 15)));

		printListPretty(students);
		Collections.sort(students);
		printListPretty(students);
		
		//System.out.println("Students sorted by their names: ");
		//Collections.sort(students, new StudentNameComparator());
		//printListPretty(students);
		}
	
	static void printListPretty(List<Student> list) {
		System.out.println("Students: ");
		for(Student a : list) {
			System.out.println(a);
		}
	}

}
