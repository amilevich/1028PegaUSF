package com.homework.qthirteen;

public class Qthirteen {

	public static void main(String[] args) {
		int triangleBase = 4;
		
		illuminati(triangleBase);

	}
	
	public static void illuminati(int tea) {
		int bitChecker = 0;
		int level = 1;
		for (int i = 0; i < tea; i++) {
			for (int j = 0; j <= i; j++) {
				if (bitChecker == 0) {
					System.out.print(bitChecker);
					bitChecker = 1;
				}else {
					System.out.print(bitChecker);
					bitChecker = 0;
				}
			}
			System.out.println("");
		}
	}

}
