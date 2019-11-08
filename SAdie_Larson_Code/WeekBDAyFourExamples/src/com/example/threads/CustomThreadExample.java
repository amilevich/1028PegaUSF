package com.example.threads;

public class CustomThreadExample {
/*
 * One way to create a thread is by extending the Thread 
 * class,Overriding the run method, instantiating it and 
 * calling start
 * 
 * ANother way is to create a class that implements
 * the Runnable interface, override the run() method, 
 * instantiate that object, pass it into a thread object,
 * and call the start
 * 
 * Pros of extending: 
 * 	less lines of code
 * 	easier to understand
 * 	easier to override the functionality of a thread
 * 
 * Pros of implementing
 * 	You don't have to use up your extends slot
 * 	Light weight (not inheriting unwanted/needed methods)
 * 
 */
	public static void main(String[] args) {

		MyThread th = new MyThread();
	//	th.run(); // since thread not run will print out main 40 times
		th.setName("Hola");
		th.start(); //will print out hola
		
		MyRunnable rn = new MyRunnable();
		Thread myTh = new Thread(rn);
		myTh.setName("Hi");
		myTh.start(); // will print out hi (Thread - 1 if not setName
		
		for(int i = 0; i < 40; i++) { //will print out main
			System.out.println("\t" + "\t" +Thread.currentThread().getName());
		}
	}

}
