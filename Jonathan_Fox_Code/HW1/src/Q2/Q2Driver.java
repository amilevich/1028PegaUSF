package Q2;

public class Q2Driver {

	// Write a program to display the first 25 Fibonacci numbers beginning at 0. 
	public static void main(String[] args) {
		int[] last = {0, 0};
		int j = 0;
		
		//25 iterations starting at 0
		for(int i=0; i<25; i++) {
			//add both numbers, store at j. this is the current fibonacci number
			last[j] = last[0] + last[1];
			//print current fibonacci number
			System.out.printf("%d ", last[j]);
			//if current fibonacci number is 0, add 1
			if(last[j] == 0) last[j] += 1;
			//swap j between 0 and 1
			j^=1;
		}
	}
}
