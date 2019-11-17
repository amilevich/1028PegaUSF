package com.example.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapsExample {
	
	public static void main(String[] args) {
		
		//Hashmap
		Map<Integer, String> hMap = new HashMap<Integer, String>();
		
		hMap.put(14, "Leaf");
		hMap.put(21, "Drinking Age");
		hMap.put(7, "Days");
		hMap.put(42, "Answer to the life and the univrse and everything");
		hMap.put(1, "Pizza");
		hMap.put(14, "Bar");
		System.out.println(hMap);
		//insertion order not guaranteed
		//maps allow null as key
		System.out.println(hMap.get(1));
		System.out.println(hMap.get(null));
		
		//for each/enhanced loop
		/*
		 * enhanced for loop that simplifies traversing over collections of data
		 * It has no explicit counter(i++)
		 * the statement goes through an array or ca collection data structure one by one and the current value
		 * is copied to a variable defined in the construct
		 */
		
		int[] intArray = {10, 7, 4, 3};
		for(int i : intArray) { // we start at 1st element
			//we go until the length of our data structure
			//increment by 1
			System.out.println(i);
		}
		
		for(Entry<Integer, String> en : hMap.entrySet()) {
			// in a map, each key value pair is called an entry
			//all entries are called entry set
			System.out.println(en.getKey() + "\t" + en.getValue());
			
		}
			
	}

}
