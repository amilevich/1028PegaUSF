package com.exampls.threads;
/*
 * One way to create thread is by extending Thread class, Overriding the run method, Instantiating it an calling start
 * 
 * Second way,create a class that implements the runnable interface, override the run() method, instatiate that object, pass into
 * a thread object, and call the start method
 * 
 * PROS of extend:
 * Less lines of code 
 * easier to override the functionality of a thread
 * 
 * Pros of Implementing:
 * Don't need to use extend slot
 * Lightweight
 */

public class CustomThread {

	public static void main(String[] args) {
		MyThread th = new MyThread();
		//th.run();
		th.start();
		
		MyRunnable mR = new MyRunnable();
		
		Thread myTh = new Thread(mR); //pass a runnable obj
		
		myTh.start();
		for(int i = 0; i<40; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}
}
