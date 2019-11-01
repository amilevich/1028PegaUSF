package com.example.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapsExample {

	
	public static void main(String[] args) {
		
		//HashMap 
		Map<Integer, String> hMap = new HashMap<Integer, String>();
		hMap.put(14,"Leaf" );
		hMap.put(21, "Drinking Age" );
		hMap.put(7, "Days" );
		hMap.put(42, "Answer to the life and universe and everything" );
		hMap.put(1, "Pizza" );
		hMap.put(14,"Ball" ); // this will overwrite the value if you have two keys that have the same value
		hMap.put(null, "empty" ); // Map allows null as key

		System.out.println(hMap);
		System.out.println(hMap.get(null));
		//Insertion error is not guarantee because HashMap has keys to identify location
		
		
		//for each/enhanced for loop
		/*
		 *the enhanced for loop that simplifies traversing over collections of data
		 *it has no explicit counter (i++)
		 *The Statement goes through an array or a collection data structure one by one and the current value is copied to a variable defined in the construct
		 * 
		 */
		
		int[] intArray = {10, 7, 4, 3};
		for(int i : intArray) { // we start at the first element, go until the length of our data structure.
								//increment by 1
								// no indices 
			System.out.println(i);
			
		for (Entry<Integer, String> en : hMap.entrySet()) {
			//in a map, each key value pair is called an entry
			//all entries are called entry set
			System.out.println(en.getKey() + "\t" + en.getValue());;
		}
		}
		
		
	}
	
}
