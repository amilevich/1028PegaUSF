package com.example.threads;

public class MyThread extends Thread{
	@Override
	public void run() {
		for(int i = 0; i < 40; i++) {
			System.out.println("\t" + Thread.currentThread().getName());
		}
	}
	

}
