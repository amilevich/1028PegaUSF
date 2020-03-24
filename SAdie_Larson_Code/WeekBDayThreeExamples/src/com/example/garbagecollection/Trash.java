package com.example.garbagecollection;

public class Trash {

	/*
	 * Heap - all objects are stored
	 * Stack - everything else 
	 * 
	 * Garbage collection - one of java's features, a process of 
	 * automatically freeing memory of the heap by deleting objects
	 * that no longer are reachable in your program
	 * i.e. objects that no longer have a reference to them
	 * 
	 * Daemon Thread  - GC (never stops running in background, always going
	 */
	public static void main(String[] args) {

		String s = "Root";
		Object o = new Object();
		Object o2;
		Object o3 = new Object();
		//checkpoint 1: no garbage collection at this point -> all objects still have way of accessing 
		o2 = 0;
		o = null;
		//checkpoint 2: no garbage collection 
		//because null is perfectly legitimate for object to hold
		s = null;
		//checkpoint 3: garbage collection -> string pool, if string is null the object itself has to be garbage collected
		o3 = new Object();
		//checkpoint 4: garbage collection -> old instance is gone
		
		System.gc(); //call the gc 
		
		/*
		 * finalize() method
		 * 
		 * method that allows you to close any connections or perform any
		 *  clean up activities before the garbage collector comes by
		 */
	}

}
