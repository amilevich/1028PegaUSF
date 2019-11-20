package Q14;

public class Q14Driver {

	// Write a program that demonstrates the switch case. Implement the following
	// functionalities in the cases:
	// Case 1: Find the square root of a number using the Math class method.
	// Case 2: Display today’s date.
	// Case 3: Split the following string and store it in a string array.
	// “I am learning Core Java”
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.printf("Arguments required (1 (number), 2, or 3)\n");
			System.exit(1);
		}

		try {
			switch (args[0]) {
			
			//printf sqrt of args[1]
			case "1":
				if(args.length >= 2) System.out.printf("%f\n", Math.sqrt(Double.valueOf(args[1])));
				else System.out.printf("Improper input\n");
				
				break;
				
			//print current date
			case "2": System.out.printf("%s", java.time.LocalDate.now()); break;
			
			//split "I am learning Core Java" delineating using " ". then print the resulting array
			case "3":
				String s = "I am learning Core Java";
				String[] sa = new String[5];
				sa = s.split(" ");
				
				for(int i = 0; i < sa.length; i++) System.out.printf("%s ", sa[i]);
				
				System.out.printf("\n");
				break;
			default: System.out.printf("Improper input\n");
			}
		} catch (NumberFormatException e) { System.out.printf("Improper input\n"); }
	}

}
