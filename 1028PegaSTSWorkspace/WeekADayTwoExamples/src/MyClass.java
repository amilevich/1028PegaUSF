import java.util.Random;

public class MyClass {
	/*
	 * if -> runs bl
	 * if nothing else did (or if no condition was met)
	 * 
	 * for -> typically is used when you know for how how long you want to loop,
	 * has a start, an end an increment
	 * 
	 * switch -> useful when you are checking a variable against
	 * a lot of conditions / values
	 * 
	 * while -> typically used when you do not know for how long you want to
	 * loop but have you condition that needs to be satisfied
	 * 
	 * do -while -> same as while, but definitely will run at least once
	 * 
	 * "continue" - go to the end of the loop and start the next iteration
	 * can be used in switch and with loops
	 * 
	 * "break" - go to the end of the loop and breaks out of the loop
	 * can be used within switch and loops
 	 */
	
	public static void main(String [] args) {
		//if statement
		//a random number is generated, if the number is greater than 0,
		//we print a message to the console
		
		Random r = new Random();
		// we are instantiating an object called "r" of type Random
		
		int num = r.nextInt();
		System.out.println(num);
		
		int num2 = 0;
		
		if(num2 > 0) {
			System.out.println("The number" + num2 + " is positive.");
		} else if (num2 < 0) {
			System.out.println("The number" + num2 + " is negative.");
		} else {
			System.out.println("The number is 0.");
		}
	}

}
