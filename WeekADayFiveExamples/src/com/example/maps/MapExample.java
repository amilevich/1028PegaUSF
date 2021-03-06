package com.example.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapExample {
	
	public static void main(String[] args) {
		
		//HashMap
		Map<Integer, String> hMap = new HashMap<Integer, String>();
		hMap.put(14, "Leaf");
		hMap.put(21, "Drinking Age");
		hMap.put(7, "Days");
		hMap.put(42, "Answer to the life and universe and everything");
		hMap.put(1, "Pizza");
		hMap.put(null, "empty");
		hMap.put(14, "Ball");
		System.out.println(hMap);
		//insertion order is NOT guaranteed
		//maps allow null as key
		System.out.println(hMap.get(1));
		System.out.println(hMap.get(null));
		
		//for each/enhanced for loop
		/*
		 * the enhanced for loop that simplifies traversing
		 * over collections of data
		 * It has no explicit counter (i++)
		 * The statement goes through an array or a collection
		 * data structure one by one and the current value is
		 * copied to a variable defined in the construct
		 */
		
		int[] intArray = {10, 7, 4, 3};
		for(int x : intArray) { //we start at the first element
			//we go until the length of our data structure
			//increment by 1
			System.out.println(x);
		}
		
		for(Entry<Integer, String> en : hMap.entrySet()) {
			// in a map, each key value pair is called an entry
			// all entries are called entry set
			System.out.println(en.getKey() + "\t" + en.getValue());
		}
		
	}

}
