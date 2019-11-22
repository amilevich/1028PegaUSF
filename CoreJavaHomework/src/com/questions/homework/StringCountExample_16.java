package com.questions.homework;

public class StringCountExample_16 {
	
	public void run(String[] args) {
		int x = 0;
		for(int i =0; i <args.length; i++) {
			x+=args[i].length();//only one args, so will print 0
		}
		System.out.println(x);
	}
}
