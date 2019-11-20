package Q11;

public class Q11Driver {

	//Write a program that would access two float-variables from a class that exists in another package. Note, you will need to create two packages to demonstrate the solution.
	public static void main(String[] args) {
		//printf floats from the Q11GrabMe class in the Q11two package
		System.out.printf("%f, %f\n", Q11two.Q11GrabMe.first, Q11two.Q11GrabMe.second);
	}

}
