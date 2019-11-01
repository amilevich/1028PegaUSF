package com.example.a1;

public class MyClass {
	
	public static void main(String[] args) {
		
		
		
		City sf = new City(889_092, "San Francisco", true);
		
		City sj = new City(1_000_000, "San Jose", true);

		City nw = new City(50_000, "Newark", false);

////		SF Object 1
//		System.out.println("This is a fun City: " + sf.isLit());
//		System.out.println("What City is this? " + sf.getName());
//		System.out.println("Population is approx: " + sf.getPopulation());
//		
////		SJ Object 2
//		System.out.println("This is a fun City: " + sj.isLit());
//		System.out.println("What City is this? " + sj.getName());
//		System.out.println("Population is approx: " + sj.getPopulation());
//		
////		NW Object 3
//		System.out.println("This is a fun City: " + nw.isLit());
//		System.out.println("What City is this? " + nw.getName());
//		System.out.println("Population is approx: " + nw.getPopulation());
		
//		System.out.println(sf.toString());
//		System.out.println(sj.toString());
//		System.out.println(nw.toString());
//		
//		
		System.out.println(sf);
		
		City[] newArray = {sf, sj, nw};
		for(int i = 0; i <newArray.length; i++) {
			System.out.println(newArray[i]);
		}
		
		sf.pizzaJoints("Best Pizza", 10, 19);
		System.out.println("\n");
		sj.pizzaJoints("Amazing Mod Pizza", 11, 120);
		System.out.println("\n");
		nw.pizzaJoints("Fake Pizza", 1, 0);

	}

}
