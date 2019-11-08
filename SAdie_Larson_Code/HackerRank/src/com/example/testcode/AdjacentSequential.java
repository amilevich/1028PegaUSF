package com.example.testcode;

public class AdjacentSequential {

	public static void main(String[] args) {
		int[] number = { 10, 4, 5, 6, 7, 8, 2, 3, 2, 9 };
		if(seqeunce(number)) {
			System.out.println("There is a sequence");
		}
		else{
			System.out.println("There is not a sequence");
		}

	}
	public static boolean seqeunce(int[] num) {
		int check = 0;
		for (int i = 0; i < num.length - 1; i++) {
			for(int j = 1; j < num.length; j++) {
				if((num[i] - num[j] == 1) || (num[i] - num[j] == -1)) {
					check++;
				}
			}
		}
		if(check > 2) {
			return true;
		}
		else {
			return false;
		}
	}
	
		
}
