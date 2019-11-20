package Q10;

public class Q10Driver {

	// Find the minimum of two numbers using ternary operators.
	public static void main(String[] args) {
		try {
			
			//check number of arguments
			if(args.length < 2) {
				System.out.printf("2 arguments required\n");
				System.exit(1);
			}
			
			//print min of first 2 args
			System.out.printf("%d\n", min(Integer.valueOf(args[0]), Integer.valueOf(args[1])));
		}
		catch(NumberFormatException e) { System.out.printf("Improper input\n"); }
	}
	
	//return min
	public static int min(int x, int y) { return (x>y)?y:x; }

}
