package com.example.assignment;

public class MyClass {
	public static void main(String[] args) {

		States ca = new States(1_230_000, "California", 0.45);
		States mn = new States(1_130_120, "Minnesota", 0.24);
		States fl = new States(1_030_080, "Florida", 0.64);

		// what it would look like without a constructor in states class
		// ca.setName("California");
		// ca.setPopulation(1_230_000);
		// ca.setPercentStudents(0.45);
		//
		// fl.setName("Florida");
		// fl.setPopulation(1_130_120);
		// fl.setPercentStudents(0.34);
		//
		// mn.setName("Minnesota");
		// mn.setPopulation(1_030_080);
		// mn.setPercentStudents(0.64);

		States.hello(); // allows a static hello world without having to create an oject

		System.out.println(ca.getName()); // same as Minnesota -> will print out California
		ca.peopleInterested(10, 20, 30, 40); // same as Minnesota

		System.out.println(fl.getName());  // same as Minnesota -> will print out Florida
		fl.peopleInterested(100, 30, 12); // // same as Minnesota

		System.out.println(" ");
		System.out.println("The next line should print out the name of Minnesota");
		System.out.println(mn.getName());

		System.out.println(" ");
		System.out
				.println("The next line should print out the people interest levels and amount of people from VarArgs");
		mn.peopleInterested(80, 60, 46, 30, 20, 12, 41, 10);

		System.out.println(" ");
		System.out.println("The next line should print out the name of states as set in the array");
		String statesList[] = { ca.getName(), fl.getName(), mn.getName() };
		for (int i = 0; i < statesList.length; i++) {
			System.out.println(statesList[i]);

		}

		System.out.println(" ");
		System.out.println("The next line should print out the toString information");
		System.out.println(ca);

	}
}
