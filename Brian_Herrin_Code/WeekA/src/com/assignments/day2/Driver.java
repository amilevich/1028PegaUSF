package com.assignments.day2;

public class Driver {
	// create at least 3 objects from your model class
	// store all objects in an array and print them out using a for loop

	// Try to format the printed-out objects in a presentable way using toString()
	// or your own custom method.
	public Driver() {

	}

	public static void fun(String name, int... a) {
		System.out.println(name + " " + a.length);
	}

	public static void main(String[] args) {
		int[] june = {123,-34,24,30,85,40,31,22,33,26,28,29};
		Bean[] beans = {new Bean("BeanyBaby", 7), new Bean("JellyBean", 8), new Bean("Mr.Bean", 9)};
		for(int i = 0; i < beans.length; i++) {
			beans[i].growBean(june);
		}
		
	}
}
