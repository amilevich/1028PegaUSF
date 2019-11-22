package interview.questions;

import java.util.ArrayList;

public class QTwelve {

	public static void main(String[] args) {
		evenPrint();
	}
	
	public static void evenPrint() {
		int[] evens = new int[100];
		int i = 0;
		for(int x:evens) {
			evens[i]=i++ ;
			if (i%2 == 0) {
				System.out.println(i);
			}
			
		}
	}

	
}
