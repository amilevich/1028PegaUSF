package com.example.testcode;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class timeconversion {

	/*
	 * Complete the timeConversion function below.
	 */
	static String timeConversion(String s) {
		String modS = "";
		int begin = (Character.getNumericValue(s.charAt(0))*10)+ Character.getNumericValue(s.charAt(1));
		if ((s.charAt(8)) == ('P') && Integer.valueOf(begin) != 12) {
			String end2 = String.valueOf(begin+12);
			modS += end2;
			for (int i = 2; i < s.length() - 2; i++) {
				modS += s.charAt(i);
			}
			return modS;
		} else if((s.charAt(8)) == ('A') && Integer.valueOf(begin) == 12){ //non midnight and non pm
			modS += "00";
			for (int i = 2; i < s.length() - 2; i++) {
				modS += s.charAt(i);
			}
			return modS;
			
		}
		else { //other cases
			for (int i = 0; i < s.length() - 2; i++) {
				modS += s.charAt(i);
			}
			return modS;
		}

	}

	public static void main(String[] args) throws IOException {

		String result = timeConversion("07:05:45PM");

		System.out.println(result);
		
		result = timeConversion("07:05:45AM");

		System.out.println(result);

		result = timeConversion("12:05:45PM");

		System.out.println(result);
		
		result = timeConversion("12:05:45AM");

		System.out.println(result);

	}
}
