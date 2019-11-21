package com.javahomework.questions;

public class QuestionThirteenClass {
	/*
	 * Display the triangle on the console as follows using any type of loop.  
	 * Do NOT use a simple group of print statements to accomplish this.
	 *   0
    	1 0
    	1 0 1
    	0 1 0 1

	 * */
	public static void main(String[] args) {
		int a = 0, b=1,c=0;
		for(int i = 0; i < 4; i++) { //<------ my for loop that start at index 0 and goes up to 4(rows)
			for(int j = 0; j<=i;j++) {//<------this for loop says second index starts at 0, index <= to i which is 0, increment
				if(c == 0) {//<---------------- if c equals 0
					System.out.print(a + " "); //<--- print out a because if c equals 0 we want to print out a since a is 0
					c = b; //<----------------- now c = to 1
				}else if(c == 1) { //<-----------if c equals 1 we print b which is 1
					System.out.print(b + " ");//<----now we print 1
					c = a; //<------------------now c is equal to 0				}
			}
			System.out.println("\n"); //<-----------new line and then goes back to the top forloop which will be index 1 and so on
		}
		
	}
	
	}
}
