package firsthw;

public class quest13 {

	public static void main(String[] args) {

		int a = 0;
		int b = 0;
		for (int i = 0; i < 10; i++) {
			System.out.print(i % 2);
			b++;
			if (b > a) {
				a = b;
				b = 0;
				System.out.println();
			}
		}

	}
}
