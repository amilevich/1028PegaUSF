package com.example.garbagecollection;

public class Trash {
	/*
	 * all objects are stored in the heap
	 * Everything else is stored in the stack
	 * 
	 * Garbage Collection - one of javas features, a process of automatically freeing memory of the heap
	 * by deleting objects that no longer have a reference to them
	 * 
	 * */
	
	public static void main(String[] args) {
		String s = "Root";
		Object o = new Object();
		Object o2;
		Object o3 = new Object();
		//checkpoint 1: no garbage collection at this point
		o2= o;
		o = null;
		//checkpoint 2: no garbage collection
		s = null;
		//checkpoint 3: garbage collection -> string pool
		o3 = new Object();
		//checkpoint 4: garbage collection -> old instance is gone
		
		System.gc(); //call the gc which will not show
		
		//we have the finalize method
		/*
		 * method that allows you to close any connections or 
		 * perform any clean up activities before the 
		 * garbage collector comes by
		 * */
	}
}
