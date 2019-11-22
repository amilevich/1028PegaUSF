package com.homework.algorthim;

public class Q16Command {

	public void command(String[] args) {
		int temp = 0;
		for(int i =0; i <args.length; i++) {
			temp+=args[i].length();
		}
		System.out.println(temp);
	}
}
