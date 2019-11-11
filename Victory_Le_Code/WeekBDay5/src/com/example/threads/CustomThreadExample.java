package com.example.threads;

/*
 * One way to create a thread is by extending the Thread class, Overriding the run method, instantiating it and calling start. 
 * 
 * Second way, create a class that implements the Runnable interface, override the run() method, instantiate that object, pass it into a thread object, and call the start method.
 * 
 * Pros of extend:
 * less line of code
 * easier to override the functionality of a thread 
 * 
 * Pros of implementing:
 * you don't have to use up extends slot 
 * lightweight 
 * 
 */
public class CustomThreadExample {

	public static void main(String[] args) {
		MyThread th = new MyThread();
		th.start();
		
		MyRunnaable mR = new MyRunnaable();
		Thread myTh = new Thread(mR);
		myTh.start();
		
		for (int i = 0; i < 40; i++) {
			System.out.println("\t\t" + Thread.currentThread().getName());
		}
	}

}
