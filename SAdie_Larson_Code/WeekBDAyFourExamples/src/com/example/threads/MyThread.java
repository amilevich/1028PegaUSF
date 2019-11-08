package com.example.threads;

public class MyThread extends Thread {

	@Override //when looking at the run method in Thread class there isn't really any logic 
	public void run() {
		for(int i = 0; i < 40; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}
}
