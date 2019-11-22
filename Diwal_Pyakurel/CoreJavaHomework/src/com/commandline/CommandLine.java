package com.commandline;

public class CommandLine {
	public static void main(String[] args) {
		//args will be array
		System.out.println("The size of the argument is "+ args.length);
		for(int i=0; i<args.length; i++) {
			System.out.println(args[i]);
			System.out.println("The length is " +args[i].length());
		}
	}
}
