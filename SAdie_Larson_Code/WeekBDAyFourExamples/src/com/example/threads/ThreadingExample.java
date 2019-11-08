package com.example.threads;

public class ThreadingExample {

	public static void main(String[] args) {

		//How do we create a thread in Java
		Thread th = new Thread();
		
		//How do we see the current thread
		System.out.println(Thread.currentThread().getName());
		
		boolean isDaemon = Thread.currentThread().isDaemon();
		System.out.println(isDaemon);
	}

}
