package com.example.garbagecollection;

public class Trash {
	
	/*
	 * In java there are two memory storage:
	 * Heap and Stack.
	 * All objects are stored in the Heap.
	 * Stack behaves like a data structure does 
	 * A stack is LIFO last in first out. 
	 * 
	 * Garbage collection - one of Java's features, 
	 * a process of automatically freeing memory of the heap by deleting objects that no longer are reachable in your program. 
	 * I.E. objects that no longer have reference to them. 
	 * Will collect any objects that does not have a reference to them. 
	 * 
	 * 
	 */

	public static void main(String[] args) {
		String s = "Root";
		Object o = new Object();
		Object o2;
		Object o3 = new Object();
		//CheckPoint 1: no garbage collection at this point. All objects are currently being used so you dont want to delete. 
		o2 = o;
		o = null;
		//Checkpoint 2:no garbage collection because null is an acceptable object to hold;
		s = null;
		//Checkpoint 3: garbage collection at this point because "String" are stored in string pool. I you make a string to null, it will be a string literal null. 
		o3 = new Object();
		//checkpoint 4: garbage collection -> old instance is gone ; Line 24 is a different object at line 31.
		
		System.gc(); // call the GC
		
		//finalize()method - you have to override this method
		// method that allows you to close any connections or perform any clean up activities before the GC comes by
		// We are able to override the method and 
		
		//You are able to force the GC to run this block of code before GC cleans up the file
		
		//What is the difference between final finally and finalize in java?
		
		
	}

}
