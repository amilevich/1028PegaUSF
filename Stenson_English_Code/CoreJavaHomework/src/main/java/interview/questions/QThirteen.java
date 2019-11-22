package interview.questions;

public class QThirteen {

	public static void main(String[] args) {
		binaryTriangle();
	}

	public static void binaryTriangle() {
		System.out.println("");

		for (int i = 1; i <= 4; i++) {
			
			if (i == 2 | i == 3) {
				for (int x = 0; x < i; x++) {
					System.out.print((x + 1) % 2);
				}
			} else {
				for (int y = 0; y < i; y++) {
					System.out.print((y) % 2);
				}
			}
			System.out.println();

		}
	
}
}
