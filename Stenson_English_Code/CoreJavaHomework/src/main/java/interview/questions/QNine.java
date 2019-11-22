package interview.questions;

import java.util.ArrayList;

public class QNine {

	public static void main(String[] args) {
		primeNumbers();
	}
	

	public static void primeNumbers() {
		ArrayList<Integer> intList = new ArrayList<Integer>();

		for (int i = 1; i <= 100; i++) {
			intList.add(i);
		}

		for (int i : intList) {

			if (isPrime(i)) {
				System.out.print(i + " ");
			}

		}

	}

	public static boolean isPrime(int x) {
		int y;
		for (int i = 2; i <= x / 2; i++) {
			y = x % i;
			
			if (y == 0) {
				return false;
			}
		}
		return true;

	}

}