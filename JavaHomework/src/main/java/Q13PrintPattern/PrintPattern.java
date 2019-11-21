package Q13PrintPattern;

public class PrintPattern {

	public static void main(String[] args) {
		
		int max=0;
		int nl=0;
		for (int i = 0; i<10; i++) {
			System.out.print(i%2);
			nl++;
			if (nl>max) {
				max=nl;
				nl=0;
				System.out.println();
			}
		}
	}
}
