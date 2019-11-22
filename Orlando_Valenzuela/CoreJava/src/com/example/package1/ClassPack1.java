package com.example.package1;

import static com.example.package2.ClassPack2.value1;
import static com.example.package2.ClassPack2.value2;

public class ClassPack1 {
	
	public static void main (String[] args) {
		
		System.out.println("the values from the class in the other package are: value1 " + value1+ " value2 " +value2);
	}

}
