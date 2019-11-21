package src.Question13;
/*
 * Display the triangle on the console as follows using any type of loop. 
   Do NOT use a simple group of print statements to accomplish this.
    0
    1 0
    1 0 1
    0 1 0 1

 */

public class MyClass {
	public static void main(String[] args) {
		int var = 0;
		// first print out the first element 0
		System.out.println(var);
		// for for the second and third levels
		for (int i = 0; i <= 1; i += 1) {
			for (int j = 0; j <= i; j++) {
				System.out.print(var + 1);

				if (j % 2 == 0) {
					System.out.print(var);
				}
			}
			System.out.print("\n");
		}
		// last level of the pyramid
		for (int i = 0; i < 3; i += 2) {
			if (i % 2 == 0) {
				System.out.print(var);
			}
			System.out.print(var + 1);
		}
	}

}
