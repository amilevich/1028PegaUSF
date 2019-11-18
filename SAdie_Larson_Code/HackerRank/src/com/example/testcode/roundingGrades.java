package com.example.testcode;

import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.IOException;

public class roundingGrades {
	/*
	 * Complete the 'gradingStudents' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * INTEGER_ARRAY grades as parameter.
	 */

	public static List<Integer> gradingStudents(List<Integer> grades) {
		List<Integer> gradesR = new ArrayList<Integer>();
		for (Integer i : grades) {
			if (i >= 38) {
				// do nothing if not close to next 5 multiple
				if (i % 5 == 3) {
					i += 2;
				}
				if(i%5 == 4) {
					i++;
				}
			} else {
				// do nothing
			}
			gradesR.add(i);
		}
		for (Integer i : gradesR) {
			System.out.println(i);
		}
		return gradesR;
	}

	public static void main(String[] args) throws IOException {

		List<Integer> grades = new ArrayList<Integer>();
		grades.add(73);
		grades.add(67);
		grades.add(38);
		grades.add(33);

		List<Integer> result = gradingStudents(grades);

		System.out.println(result);
	}
}
