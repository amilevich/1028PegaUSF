package com.example.threads;

public class CustomThreadExample {
	/*
	 * One way to create a thread is by extending the thread class
	 * Overriding the run method, instantiating it and calling stasrt.
	 * 
	 * Second way, create a class that implements the runnable interface,
	 * override the run() method,  instantiate that object, pass it into a thread object, and call the start()
	 * method.
	 * 
	 * Pros of extend:
	 * less lines of code
	 * easier to override the functionality of a thread
	 * 
	 * Pros of implementing:
	 * you don't have to use up you extends slot lightweight
	 */

	public static void main(String[] args) {
		MyThread th = new MyThread();
		//th.run();
		th.start();
		MyRunnable mR = new MyRunnable();
		Thread myTh = new Thread(mR);
		myTh.start();
		
		for(int i = 0; i < 40; i++) {
			System.out.println( Thread.currentThread().getName());
		}

	}

}
