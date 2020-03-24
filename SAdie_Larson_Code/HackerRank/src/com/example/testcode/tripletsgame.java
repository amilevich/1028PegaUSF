package com.example.testcode;

import java.io.*;
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

public class tripletsgame {

	// Complete the compareTriplets function below.
	static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
		int score[] = { 0, 0 };
		ListIterator<Integer> it = b.listIterator();
		for (Integer i : a) {

			Integer j = it.next();
			if (i > j) {
				score[0] += 1;
			} else if (j > i) {
				score[1] += 1;
			}
		}
		List<Integer> scores = new ArrayList<Integer>();
		scores.add(score[0]);
		scores.add(score[1]);
		return scores;
	}

	public static void main(String[] args) throws IOException {

		List<Integer> a = new ArrayList<Integer>();
		a.add(6);
		a.add(7);
		a.add(2);
		List<Integer> b = new ArrayList<Integer>();
		b.add(2);
		b.add(7);
		b.add(6);
		List<Integer> result = compareTriplets(a, b);

		System.out.println(result);
	}
}
