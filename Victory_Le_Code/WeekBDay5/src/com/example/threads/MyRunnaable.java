package com.example.threads;

public class MyRunnaable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 40; i++) {
			System.out.println("\t\t" + Thread.currentThread().getName());
		}
	}

}
