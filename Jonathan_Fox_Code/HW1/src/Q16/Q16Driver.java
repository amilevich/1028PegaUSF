package Q16;

public class Q16Driver {
	
	//Write a program to display the number of characters for a string input. The string should be entered as a command line argument using (String [ ] args).
	public static void main(String[] args) {
		int sum = 0;
		
		//add length of each element in args
		for(int i = 0; i < args.length; i++) sum += args[i].length();
		
		System.out.printf("number of non-space characters: %d\n", sum);
	}
}
