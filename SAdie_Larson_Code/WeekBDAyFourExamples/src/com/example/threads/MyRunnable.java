package com.example.threads;

public class MyRunnable implements Runnable { 
/*
 * (non-Javadoc)
 * @see java.lang.Runnable#run()
 * 
 * if you want a thread that you want to extend another 
 * class you don't want to extend Thread just use the interface Runnable
 */
	@Override
	public void run() {
		for(int i = 0; i < 40; i++) {
			System.out.println("\t" + Thread.currentThread().getName());
		}
	}


	
}
