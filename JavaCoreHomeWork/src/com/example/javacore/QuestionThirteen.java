package com.example.javacore;
/*
 * Display the triangle on the console as follows using any type of loop.
 * Do NOT use a simple group of print statements to accomplish this.
 *  0
    1 0
    1 0 1
    0 1 0 1

 */
public class QuestionThirteen {

	public static void main(String[] args) {

		int a = 0, b = 1, c = 0;
		for(int i = 0; i < 4; i++) {
			for(int q = 0; q <= i; q++) {
				if(c == 0) {
					System.out.print(a + " ");
					c = b;
				}else if(c == 1) {
					System.out.print(b + " ");
					c = a;
				}
			}
			System.out.println("\n");
		}
		
	}

}
