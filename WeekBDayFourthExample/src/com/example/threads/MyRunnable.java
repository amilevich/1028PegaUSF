package com.example.threads;

public class MyRunnable implements Runnable{

	@Override
	public void run() {
		for(int i = 0; i < 40; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}

}
